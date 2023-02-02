package com.example.kosthub.ui.pemilik.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kosthub.data.remote.model.kostroom.response.AllKostResponse
import com.example.kosthub.databinding.CardPemilikKostBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class PemilikDaftarKostAdapter(
    private val listKost: List<AllKostResponse>,
    private val onClick: (AllKostResponse) -> Unit
) : RecyclerView.Adapter<PemilikDaftarKostAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = CardPemilikKostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val kost = listKost[position]
        holder.binding.apply {
            kost.apply {
//                Glide.with(cardPemilikKost)
//                    .load(kost.image)
//                    .into(ivKost)

                menuKebab.setOnClickListener {
                    onClick(kost)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return listKost.size
    }

    class Holder(val binding: CardPemilikKostBinding) : RecyclerView.ViewHolder(binding.root)

}