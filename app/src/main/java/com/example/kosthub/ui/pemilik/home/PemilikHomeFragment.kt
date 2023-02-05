package com.example.kosthub.ui.pemilik.home

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Html
import android.text.SpannableStringBuilder
import android.view.*
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.core.text.bold
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.models.SlideModel
import com.example.kosthub.R
import com.example.kosthub.application.MainActivity
import com.example.kosthub.data.remote.model.kostroom.response.AllKostResponse
import com.example.kosthub.data.remote.model.user.response.StatisticResponse
import com.example.kosthub.databinding.DialogPemilikListKostBinding
import com.example.kosthub.databinding.FragmentPemilikHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlin.system.exitProcess

@AndroidEntryPoint
class PemilikHomeFragment : Fragment() {
    private var _binding: FragmentPemilikHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var listkost: List<AllKostResponse>

    private val viewModel: PemilikHomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPemilikHomeBinding.inflate(layoutInflater, container, false)
        (activity as MainActivity).showNavbar(R.menu.pemilik_bottom_navigation_menu)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listkost = listOf(
            AllKostResponse(image = "", address = "", id = "", label = "", type = ""),
            AllKostResponse(image = "", address = "", id = "", label = "", type = "")
        )

        viewModel.getStatistic.observe(viewLifecycleOwner) {
            if (it.status == "200") {
                it.data?.apply {
                    binding.apply {
                        tvKosong.text = emptyRooms.toString()
                        tvPemesan.text = bookers.toString()
                        tvPenghuni.text = occupants.toString()
                    }
                }
            }
        }

        showRecycler()
        showPromoCard()

        binding.btnTambahKost.setOnClickListener {
            val toTambahKost = PemilikHomeFragmentDirections.actionPemilikHomeFragmentToPemilikTambahKostFragment(true)
            findNavController().navigate(toTambahKost)
        }

        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, backPressedDispatcher)
    }

    private val backPressedDispatcher = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            onBackPressed()
        }
    }

    private fun onBackPressed() {
        exitProcess(-1)
    }

    private fun showPromoCard() {
        binding.apply {
            val imageList = listOf(
                SlideModel(R.drawable.image_promo_pemilik),
                SlideModel(R.drawable.image_promo_pemilik),
                SlideModel(R.drawable.image_promo_pemilik),
            )
            isPromo.setImageList(imageList)
        }
    }

    private fun showRecycler() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = PemilikDaftarKostAdapter(
                listKost = listkost,
                onClick = {
                    kebabMenuClicked(it)
                }
            )
        }
    }

    private fun kebabMenuClicked(kost: AllKostResponse) {
        val dialog = BottomSheetDialog(requireContext())
        val dialogBinding = DialogPemilikListKostBinding.inflate(LayoutInflater.from(requireContext()))

        dialogBinding.apply {
            cardLihatKamar.setOnClickListener {
                dialog.dismiss()
                val toListKamar = PemilikHomeFragmentDirections.actionPemilikHomeFragmentToPemilikDaftarKamarFragment()
                findNavController().navigate(toListKamar)
            }
            cardUbahKost.setOnClickListener {
                val toTambahKost = PemilikHomeFragmentDirections.actionPemilikHomeFragmentToPemilikTambahKostFragment(false)
                findNavController().navigate(toTambahKost)
            }
        }

        dialog.setContentView(dialogBinding.root)
        dialog.show()
        dialog.setCancelable(true)
    }
}