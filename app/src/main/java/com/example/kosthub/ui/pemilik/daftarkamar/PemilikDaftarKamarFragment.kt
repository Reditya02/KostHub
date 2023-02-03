package com.example.kosthub.ui.pemilik.daftarkamar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kosthub.R
import com.example.kosthub.data.remote.model.kostroom.response.AllKostResponse
import com.example.kosthub.databinding.DialogPemilikListKamarBinding
import com.example.kosthub.databinding.DialogPemilikListKostBinding
import com.example.kosthub.databinding.FragmentPemilikDaftarKamarBinding
import com.example.kosthub.databinding.FragmentPemilikHomeBinding
import com.example.kosthub.ui.pemilik.home.PemilikDaftarKostAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PemilikDaftarKamarFragment : Fragment() {
    private var _binding: FragmentPemilikDaftarKamarBinding? = null
    private val binding get() = _binding!!

    private lateinit var listKamar: List<Unit>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPemilikDaftarKamarBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listKamar = listOf(
            Unit, Unit, Unit
        )

        showRecycler()
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    private fun showRecycler() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = PemilikDaftarKamarAdapter(
                listKamar = listKamar,
                onClick = {
                    kebabMenuClicked(it)
                }
            )
        }
    }

    private fun kebabMenuClicked(kamar: Unit) {
        val dialog = BottomSheetDialog(requireContext())
        val dialogBinding = DialogPemilikListKamarBinding.inflate(LayoutInflater.from(requireContext()))

        dialogBinding.apply {

        }

        dialog.setContentView(dialogBinding.root)
        dialog.show()
        dialog.setCancelable(true)
    }
}