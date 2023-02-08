package com.example.kosthub.ui.pemilik.successtambahkost

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kosthub.databinding.FragmentPemilikSuccessTambahKostBinding

class PemilikSuccessTambahKostFragment : Fragment() {
    private var _binding: FragmentPemilikSuccessTambahKostBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPemilikSuccessTambahKostBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val isNew = PemilikSuccessTambahKostFragmentArgs.fromBundle(arguments as Bundle).isNew

        binding.apply {
            if (!isNew) {
                tvTitle.text = "Kost Berhasil di Ubah"
                tvMessage.text = "Selamat kost kamu berhasil di ubah, kamu bisa cek semua kost kamu di halaman beranda."
            } else {
                tvTitle.text = "Kost Berhasil Ditambahkan"
                tvMessage.text = "Selamat kost kamu berhasil di tambahkan, kamu bisa cek semua kost kamu di halaman beranda."
            }

            btnLihatKost.setOnClickListener {
                val toKost = PemilikSuccessTambahKostFragmentDirections.actionPemilikSuccessTambahFragmentToPemilikDaftarKamarFragment()
                findNavController().navigate(toKost)
            }
            tvHome.setOnClickListener {
                val toHome = PemilikSuccessTambahKostFragmentDirections.actionPemilikSuccessTambahFragmentToPemilikHomeFragment()
                findNavController().navigate(toHome)
            }
        }
    }
}