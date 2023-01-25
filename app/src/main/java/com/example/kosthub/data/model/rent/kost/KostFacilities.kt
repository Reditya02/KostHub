package com.example.kosthub.data.model.rent.kost

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class KostFacilities(
    val id: Int,
    val facilityName: String,
    val type: String
) : Parcelable
