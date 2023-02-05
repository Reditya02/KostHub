package com.example.kosthub.ui.pemilik.tambahkost

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kosthub.R
import com.example.kosthub.application.MainActivity
import com.example.kosthub.data.remote.model.kostroom.response.Location
import com.example.kosthub.databinding.FragmentPemilikTambahKostLocationBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class PemilikTambahKostLocationFragment : Fragment() {
    private var _binding: FragmentPemilikTambahKostLocationBinding? = null
    private val binding get() = _binding!!

    var address = Location()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as MainActivity).hideNavbar()

        _binding = FragmentPemilikTambahKostLocationBinding
            .inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.apply {
            childFragmentManager
                .beginTransaction()
                .replace(R.id.map, MapsFragment())
                .commit()

            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }

            btnAddKost.setOnClickListener {
                val toSuccessPage = PemilikTambahKostLocationFragmentDirections.actionPemilikTambahKostLocationFragmentToPemilikSuccessTambahFragment()
                findNavController().navigate(toSuccessPage)
            }
        }
    }

    private fun isAddressValid(address: String): Boolean {
        address.apply {
            if (contains("Jl. ") || contains("No. ") || contains("Gg. ")) {
                return true
            }
        }
        return false
    }

    fun retrieveAdress(inAddress: String, latLng: LatLng) {
        val listAddress = inAddress.split(", ")

        val size = listAddress.size

        if (isAddressValid(inAddress) && listAddress.size > 4) {
            var modifier = 0

            run breaking@ {
                listAddress.forEach {
                    if (!isAddressValid(it)) modifier++ else return@breaking
                }
            }

            address = Location(
                address = listAddress[0+modifier],
                province = listAddress[4+modifier].substringBeforeLast(" "),
                city = listAddress[3+modifier],
                district = listAddress[2+modifier],
                long = latLng.longitude,
                lat = latLng.latitude
            )
        }
        else {
            address = Location(
                address = listAddress[size-5],
                province = listAddress[size-2].substringBeforeLast(" "),
                city = listAddress[size-3],
                district = listAddress[size-4],
                long = latLng.longitude,
                lat = latLng.latitude
            )
        }

        binding.apply {
            address.apply {
                tfAlamat.editText?.setText(address)
                tfProvinsi.editText?.setText(province)
                tfKota.editText?.setText(city)
                tfKecamatan.editText?.setText(district)
            }
        }
    }

}