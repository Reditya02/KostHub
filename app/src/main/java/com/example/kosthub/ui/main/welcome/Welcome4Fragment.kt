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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Welcome4Fragment : Fragment() {
    private var _binding: FragmentWelcome4Binding? = null
    private val binding get() = _binding!!

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
                val toPilihRoleFragment = Welcome4FragmentDirections.actionWelcomeFragment4ToPilihRoleFragment()
                findNavController().navigate(toPilihRoleFragment)
            }



        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}