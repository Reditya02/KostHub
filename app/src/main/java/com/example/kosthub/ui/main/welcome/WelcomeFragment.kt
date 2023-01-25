package com.example.kosthub.ui.main.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.kosthub.databinding.FragmentWelcome3Binding
import com.example.kosthub.databinding.FragmentWelcomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeFragment : Fragment() {
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

            btnLewati.setOnClickListener {
                val toWelcomeFragment2 = WelcomeFragmentDirections.actionWelcomeFragmentToWelcomeFragment2()
                findNavController().navigate(toWelcomeFragment2)
            }

            btnNext.setOnClickListener{
                val toWelcomeFragment4 = WelcomeFragmentDirections.actionWelcomeFragmentToWelcomeFragment2()
                findNavController().navigate(toWelcomeFragment4)
            }

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}