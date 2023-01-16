package com.example.kosthub.data.model.tranasaction

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Payment(
    val id: Int,
    val type: String,
    val name: String
) : Parcelable