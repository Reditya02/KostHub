package com.example.kosthub.ui.main.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.kosthub.R
import com.example.kosthub.databinding.FragmentTermOfServiceBinding
import com.example.kosthub.databinding.FragmentWelcome3Binding
import com.example.kosthub.ui.main.welcome.WelcomeFragmentDirections
import com.example.kosthub.ui.main.welcome.WelcomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TermOfServiceFragment : Fragment() {

    private var _binding: FragmentTermOfServiceBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WelcomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTermOfServiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            btnBatal.setOnClickListener {
                val toRegister = TermOfServiceFragmentDirections.actionTermOfServiceFragmentToRegisterFragment()
                findNavController().navigate(toRegister)
            }


            btnSetuju.setOnClickListener {
                val toMetode = TermOfServiceFragmentDirections.actionTermOfServiceFragmentToMetodeFragment()
                findNavController().navigate(toMetode)
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}