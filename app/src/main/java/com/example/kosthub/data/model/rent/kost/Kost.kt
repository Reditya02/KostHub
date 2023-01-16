package com.example.kosthub.data.model.rent.kost

import android.os.Parcelable
import com.example.kosthub.data.model.rent.Thumbnail
import com.example.kosthub.data.model.rent.room.Room
import com.example.kosthub.data.model.user.Account
import kotlinx.parcelize.Parcelize

@Parcelize
data class Kost(
    val id: Int,
    val kostName: String,
    val frontPhotoUrl: String,
    val backPhotoUrl: String,
    val additionalKostRule: String,
    val owner: Account,
    val room: Room,
    val thumbnail: Thumbnail,
    val facility: KostFacilities,
    val kostLocation: KostLocation,
    val kostRule: KostRule
) : Parcelable