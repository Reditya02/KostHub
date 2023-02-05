package com.example.kosthub.ui.pemilik.successtambah

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kosthub.R
import com.example.kosthub.databinding.FragmentPemilikSuccessTambahBinding

class PemilikSuccessTambahFragment : Fragment() {
    private var _binding: FragmentPemilikSuccessTambahBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPemilikSuccessTambahBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnLihatKost.setOnClickListener {
                val toKost = PemilikSuccessTambahFragmentDirections.actionPemilikSuccessTambahFragmentToPemilikDaftarKamarFragment()
                findNavController().navigate(toKost)
            }
            tvHome.setOnClickListener {
                val toHome = PemilikSuccessTambahFragmentDirections.actionPemilikSuccessTambahFragmentToPemilikHomeFragment()
                findNavController().navigate(toHome)
            }
        }
    }
}