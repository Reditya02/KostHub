package com.example.kosthub.ui.pemilik

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kosthub.data.locale.raw.CheckableItem
import com.example.kosthub.databinding.CheckboxItemBinding

class CheckboxAdapter(
    private val listCheckbox: List<CheckableItem>,
    private val onClick: (Int, Boolean) -> Unit
) : RecyclerView.Adapter<CheckboxAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = CheckboxItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = listCheckbox[position]
        holder.binding.apply {
            item.apply {
                if (image == 0) {
                    ivIcon.visibility = View.GONE
                } else {
                    ivIcon.setBackgroundResource(image)
                }
                tvLabel.text = label
            }

            checkbox.setOnCheckedChangeListener { _, isChecked ->
                onClick(item.id, isChecked)
            }
        }
    }

    override fun getItemCount(): Int {
        return listCheckbox.size
    }

    class Holder(val binding: CheckboxItemBinding) : RecyclerView.ViewHolder(binding.root)

}