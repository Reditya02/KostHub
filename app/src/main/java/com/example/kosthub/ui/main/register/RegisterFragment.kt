package com.example.kosthub.ui.main.register

import android.os.Bundle
import android.util.Log
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
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvSudahPunyaAkun.setOnClickListener {
            Log.d("Reditya", "punya akun")
            val toLogin = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
            findNavController().navigate(toLogin)
        }

        binding.btnDaftar.setOnClickListener {
            Log.d("Reditya", "daftar")
            val toTOS = RegisterFragmentDirections.actionRegisterFragmentToTermOfServiceFragment()
            findNavController().navigate(toTOS)
        }

        binding.btnBack.setOnClickListener{
            Log.d("Reditya", "back")
            val toPilihRole = RegisterFragmentDirections.actionRegisterFragmentToPilihRole()
            findNavController().navigate(toPilihRole)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}