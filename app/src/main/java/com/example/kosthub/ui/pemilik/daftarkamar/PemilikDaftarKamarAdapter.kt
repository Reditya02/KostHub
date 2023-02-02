package com.example.kosthub.ui.pemilik.daftarkamar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kosthub.databinding.CardPemilikKamarBinding

class PemilikDaftarKamarAdapter(
    private val listKamar: List<Unit>,
    private val onClick: (Unit) -> Unit
) : RecyclerView.Adapter<PemilikDaftarKamarAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = CardPemilikKamarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val kamar = listKamar[position]
        holder.binding.apply {
            kamar.apply {
                menuKebab.setOnClickListener {
                    onClick(kamar)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return listKamar.size
    }

    class Holder(val binding:CardPemilikKamarBinding) : RecyclerView.ViewHolder(binding.root)
}