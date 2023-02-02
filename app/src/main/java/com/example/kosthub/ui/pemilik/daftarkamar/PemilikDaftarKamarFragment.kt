package com.example.kosthub.ui.pemilik.daftarkamar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kosthub.R
import com.example.kosthub.databinding.FragmentPemilikDaftarKamarBinding
import com.example.kosthub.databinding.FragmentPemilikHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PemilikDaftarKamarFragment : Fragment() {
    private var _binding: FragmentPemilikDaftarKamarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPemilikDaftarKamarBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}