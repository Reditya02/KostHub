package com.example.kosthub.ui.main.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.kosthub.R
import com.example.kosthub.databinding.FragmentWelcome4Binding
import com.example.kosthub.databinding.FragmentWelcomeBinding


class Welcome4Fragment : Fragment() {
    private var _binding: FragmentWelcome4Binding? = null
    private val binding get() = _binding!!

    private val viewModel: WelcomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcome4Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            btnMulai.setOnClickListener{
                val _toPilihRoleFragment = Welcome4FragmentDirections.actionWelcomeFragment4ToPilihRoleFragment()
                findNavController().navigate(_toPilihRoleFragment)
            }

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}