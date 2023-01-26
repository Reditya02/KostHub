package com.example.kosthub.ui.main.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kosthub.R
import com.example.kosthub.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvSudahPunyaAkun.setOnClickListener {
            val toLogin = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
            findNavController().navigate(toLogin)
        }

        binding.btnDaftar.setOnClickListener {
            val toTOS = RegisterFragmentDirections.actionRegisterFragmentToTermOfServiceFragment()
            findNavController().navigate(toTOS)
        }

        binding.btnBack.setOnClickListener{
            val toPilihRole = RegisterFragmentDirections.actionRegisterFragmentToPilihRole()
            findNavController().navigate(toPilihRole)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}