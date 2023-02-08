package com.example.kosthub.ui.pemilik.successtambahkamar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kosthub.R
import com.example.kosthub.databinding.FragmentPemilikSuccessTambahKamarBinding
import com.example.kosthub.databinding.FragmentPemilikTambahKamarBinding
import com.example.kosthub.ui.pemilik.successtambahkost.PemilikSuccessTambahKostFragmentDirections

class PemilikSuccessTambahKamarFragment : Fragment() {

    private var _binding: FragmentPemilikSuccessTambahKamarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPemilikSuccessTambahKamarBinding
            .inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val isNew = PemilikSuccessTambahKamarFragmentArgs.fromBundle(arguments as Bundle).isNew

        binding.apply {
            if (!isNew) {
                tvTitle.text = "Kamar Berhasil di Tambahkan"
                tvMessage.text = "Selamat tipe kamar kost kamu berhasil di tambahkan, kamu bisa cek semua tipe kamar kost kamu di halaman detail kost."
            } else {
                tvTitle.text = "Kamar Berhasil di Ubah"
                tvMessage.text = "Selamat tipe kamar kost kamu berhasil di ubah kamu bisa cek semua tipe kamar kost kamu di halaman detail kost."
            }

            btnLihatKamar.setOnClickListener {
                val toKamar = PemilikSuccessTambahKamarFragmentDirections.actionPemilikSuccessTambahKamarFragmentToPemilikDaftarKamarFragment()
                findNavController().navigate(toKamar)
            }
            tvHome.setOnClickListener {
                val toHome = PemilikSuccessTambahKamarFragmentDirections.actionPemilikSuccessTambahKamarFragmentToPemilikHomeFragment()
                findNavController().navigate(toHome)
            }
        }

    }
}