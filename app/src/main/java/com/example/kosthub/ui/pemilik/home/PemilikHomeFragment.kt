package com.example.kosthub.ui.pemilik.home

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Html
import android.text.SpannableStringBuilder
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.text.bold
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.models.SlideModel
import com.example.kosthub.R
import com.example.kosthub.application.MainActivity
import com.example.kosthub.data.remote.model.kostroom.response.AllKostResponse
import com.example.kosthub.databinding.DialogPemilikListKostBinding
import com.example.kosthub.databinding.FragmentPemilikHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PemilikHomeFragment : Fragment() {
    private var _binding: FragmentPemilikHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var listkost: List<AllKostResponse>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPemilikHomeBinding.inflate(layoutInflater, container, false)
        (activity as MainActivity).apply {
            showNavbar(R.menu.pemilik_bottom_navigation_menu)
            supportActionBar?.hide()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listkost = listOf(
            AllKostResponse(image = "", address = "", id = "", label = "", type = ""),
            AllKostResponse(image = "", address = "", id = "", label = "", type = "")
        )

        showRecycler()
        showPromoCard()


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

        }

        dialog.setContentView(dialogBinding.root)
        dialog.show()
        dialog.setCancelable(true)
    }
}