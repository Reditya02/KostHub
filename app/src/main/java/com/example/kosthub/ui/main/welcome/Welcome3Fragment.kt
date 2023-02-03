package com.example.kosthub.ui.main.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.kosthub.R
import com.example.kosthub.databinding.FragmentWelcome2Binding
import com.example.kosthub.databinding.FragmentWelcome3Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Welcome3Fragment : Fragment() {
    private var _binding: FragmentWelcome3Binding? = null
    private val binding get() = _binding!!

    private val viewModel: WelcomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcome3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            btnNext.setOnClickListener {
                val toWelcomeFragment4 = Welcome3FragmentDirections.actionWelcomeFragment3ToWelcomeFragment4()
                findNavController().navigate(toWelcomeFragment4)
            }

            btnLewati.setOnClickListener{
                val toWelcomeFragment4 = Welcome3FragmentDirections.actionWelcomeFragment3ToWelcomeFragment4()
                findNavController().navigate(toWelcomeFragment4)
            }

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}