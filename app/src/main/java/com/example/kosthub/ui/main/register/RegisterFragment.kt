package com.example.kosthub.ui.main.register

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.kosthub.R
import com.example.kosthub.data.remote.model.user.request.RegisterRequest
import com.example.kosthub.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            tvSudahPunyaAkun.setOnClickListener {
                val toLogin = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
                findNavController().navigate(toLogin)
            }

            btnDaftar.setOnClickListener {
                val data = RegisterRequest(
                    password = edtPassword.text.toString(),
                    phone = edtPhoneNumber.text.toString(),
                    email = edtEmail.text.toString()
                )

                val toTOS = RegisterFragmentDirections.actionRegisterFragmentToTermOfServiceFragment()
                findNavController().navigate(toTOS)
            }

            btnBack.setOnClickListener{
                val toPilihRole = RegisterFragmentDirections.actionRegisterFragmentToPilihRole()
                findNavController().navigate(toPilihRole)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}