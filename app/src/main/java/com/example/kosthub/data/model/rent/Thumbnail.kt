package com.example.kosthub.data.model.rent

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Thumbnail(
    val id: Int,
    val thumbnail: String
) : Parcelable