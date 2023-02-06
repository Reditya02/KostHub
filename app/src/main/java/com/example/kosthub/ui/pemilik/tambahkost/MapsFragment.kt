package com.example.kosthub.ui.pemilik.tambahkost

import android.location.Geocoder
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kosthub.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.io.IOException
import java.util.*

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        val point = LatLng(-6.175392, 106.827153)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 12f))
        googleMap.uiSettings.apply {
            isZoomControlsEnabled = true
            isZoomGesturesEnabled = true
            isCompassEnabled = true
            isMapToolbarEnabled = true
            isIndoorLevelPickerEnabled = true
        }

        googleMap.setOnMapLongClickListener {
            googleMap.apply {
                clear()
                addMarker(
                    MarkerOptions().position(it)
                )
            }
            val address = getAddressName(it.latitude, it.longitude)

            (parentFragment as PemilikTambahKostLocationFragment).retrieveAdress(address!!, it)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    private fun getAddressName(lat: Double, lon: Double): String? {
        var addressName: String? = null
        val geocoder = Geocoder(requireContext(), Locale.getDefault())
        val list = geocoder.getFromLocation(lat, lon, 1)
        if (list != null && list.size != 0) {
            addressName = list[0].getAddressLine(0)
        }
        return addressName
    }
}