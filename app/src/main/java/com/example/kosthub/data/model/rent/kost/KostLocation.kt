package com.example.kosthub.data.model.rent.kost

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class KostLocation(
    val id: Int,
    val street: String,
    val rtrw: String,
    val urbanVillage: String,
    val longitude: Double,
    val latitude: Double,
    val province: String,
    val city: String,
    val postalCode: String,
    val subDistrict: String
) : Parcelable
