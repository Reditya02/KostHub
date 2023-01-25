package com.example.kosthub.data.model.rent.room

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AdditionalFacilities(
    val id: Int,
    val facilityName: String,
    val price: Double,
    val room: Room
) : Parcelable