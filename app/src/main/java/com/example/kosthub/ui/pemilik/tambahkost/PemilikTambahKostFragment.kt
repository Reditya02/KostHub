package com.example.kosthub.ui.pemilik.tambahkost

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kosthub.R
import com.example.kosthub.application.MainActivity
import com.example.kosthub.data.locale.raw.ListCheckableItem
import com.example.kosthub.databinding.FragmentPemilikHomeBinding
import com.example.kosthub.databinding.FragmentPemilikTambahKostBinding
import com.example.kosthub.ui.pemilik.CheckboxAdapter
import com.example.kosthub.utils.Const

class PemilikTambahKostFragment : Fragment() {

    private var _binding: FragmentPemilikTambahKostBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as MainActivity).hideNavbar()
        _binding = FragmentPemilikTambahKostBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnNext.setOnClickListener {
                val toLocation = PemilikTambahKostFragmentDirections.actionPemilikTambahKostFragmentToPemilikTambahKostLocationFragment()
                findNavController().navigate(toLocation)
            }
            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }

        showRvKostRules()
        showRvKostFacility()
        showRvPaymentScheme()
    }

    private fun showRvKostRules() {
        binding.rvKostRules.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CheckboxAdapter(
                listCheckbox = ListCheckableItem.peraturanKost,
                onClick = { id, checked ->

                }
            )
        }
    }

    private fun showRvKostFacility() {
        binding.rvFacility.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CheckboxAdapter(
                listCheckbox = ListCheckableItem.fasilitasKost,
                onClick = { id, checked ->

                }
            )
        }
    }

    private fun showRvPaymentScheme() {
        binding.rvPaymentScheme.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = CheckboxAdapter(
                listCheckbox = ListCheckableItem.skemaPembayaran,
                onClick = { id, checked ->

                }
            )
        }
    }
}