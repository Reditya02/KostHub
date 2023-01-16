package com.example.kosthub.data.model.rent.kost

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class KostRule(
    val rule: String,
    val description: String
) : Parcelable
