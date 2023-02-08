package com.example.kosthub.ui.pemilik.tambahkamar

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kosthub.data.remote.model.kostroom.request.AddFacilitiesItem
import com.example.kosthub.databinding.CardPemilikAdditionalFeaturesBinding

class AdditionalFeatureAdapter(
    private var listItem: MutableList<AddFacilitiesItem>
) : RecyclerView.Adapter<AdditionalFeatureAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = CardPemilikAdditionalFeaturesBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = listItem[position]
        holder.binding.apply {
            edtName.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    item.name = s.toString()

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    item.name = s.toString()
                }

                override fun afterTextChanged(s: Editable?) {
                    item.price = s.toString()
                }
            })
            edtPrice.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    item.price = s.toString()
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    item.price = s.toString()
                }

                override fun afterTextChanged(s: Editable?) {
                    item.price = s.toString()
                }
            })
        }
    }

    override fun getItemCount() = listItem.size

    fun addFacility() {
        listItem.add(
            AddFacilitiesItem()
        )
        notifyDataSetChanged()
    }

    fun getAllData() = listItem

    class Holder(val binding: CardPemilikAdditionalFeaturesBinding)
        : RecyclerView.ViewHolder(binding.root)
}