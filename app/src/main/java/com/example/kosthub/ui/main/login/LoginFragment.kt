package com.example.kosthub.ui.main.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kosthub.R
import com.example.kosthub.databinding.FragmentLoginBinding
import com.example.kosthub.utils.Const
import com.example.kosthub.utils.Role

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            tvBelumPunyaAkun.setOnClickListener{
                val toRegister = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
                findNavController().navigate(toRegister)
            }
            btnBack.setOnClickListener {
                val toPilihRole = LoginFragmentDirections.actionLoginFragmentToPilihRoleFragment()
                findNavController().navigate(toPilihRole)
            }
            btnMasuk.setOnClickListener {
                if (Const.loginType == Role.pemilik) {
                    val toPemilikHome = LoginFragmentDirections.actionLoginFragmentToPemilikHomeFragment()
                    findNavController().navigate(toPemilikHome)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}