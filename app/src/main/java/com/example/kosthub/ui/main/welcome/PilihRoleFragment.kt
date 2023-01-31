package com.example.kosthub.ui.main.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.kosthub.R
import com.example.kosthub.databinding.FragmentPilihRoleBinding
import com.example.kosthub.databinding.FragmentWelcome3Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PilihRoleFragment : Fragment() {
    private var _binding: FragmentPilihRoleBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WelcomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPilihRoleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            btnPilih.setOnClickListener {
                val toRegister = PilihRoleFragmentDirections.actionPilihRoleFragmentToRegisterFragment()
                findNavController().navigate(toRegister)
            }

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}