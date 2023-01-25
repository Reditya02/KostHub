package com.example.kosthub.data.model.rent.room

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RoomFacilities(
    val id: Int,
    val facilityName: String,
    val type: String
) : Parcelable
