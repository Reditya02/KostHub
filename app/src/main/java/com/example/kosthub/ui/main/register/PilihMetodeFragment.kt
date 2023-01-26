package com.example.kosthub.ui.main.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kosthub.R
import com.example.kosthub.databinding.FragmentPilihMetodeBinding



class PilihMetodeFragment : Fragment() {
    private var _binding: FragmentPilihMetodeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPilihMetodeBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


       binding.btnWhatsapp.setOnClickListener{
           val whatsappVerification = PilihMetodeFragmentDirections.actionPilihMetodeFragmentToOtpVerificationFragment()
           findNavController().navigate(whatsappVerification)
       }

        binding.btnGmail.setOnClickListener{
            val gmailVerification = PilihMetodeFragmentDirections.actionPilihMetodeFragmentToOtpVerificationFragment()
            findNavController().navigate(gmailVerification)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}