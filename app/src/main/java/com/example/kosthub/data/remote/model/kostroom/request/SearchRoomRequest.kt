package com.example.kosthub.data.remote.model.kostroom.request

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchRoomRequest(
    val keyword: String? = null,
    val label: String? = null,
    val type: String? = null,
    val priceMin: Long? = null,
    val priceMax: Long? = null,
    val size: Int? = null
) : Parcelable