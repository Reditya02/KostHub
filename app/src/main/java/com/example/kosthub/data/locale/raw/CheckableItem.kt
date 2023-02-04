package com.example.kosthub.data.locale.raw

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CheckableItem(
    val id: Int,
    val image: Int = 0,
    val label: String,
    val isChecked: Boolean = false
) : Parcelable
