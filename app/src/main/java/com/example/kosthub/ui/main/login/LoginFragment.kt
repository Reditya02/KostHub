package com.example.kosthub.ui.main.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.kosthub.R
import com.example.kosthub.data.remote.model.user.request.LoginRequest
import com.example.kosthub.databinding.FragmentLoginBinding
import com.example.kosthub.utils.Const
import com.example.kosthub.utils.Role
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

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
                findNavController().popBackStack()
            }
            btnMasuk.setOnClickListener {
                if (Const.loginType == Role.pemilik) {
                    val data = LoginRequest(
                        password = edtPassword.text.toString(),
                        email = edtEmail.text.toString()
                    )
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