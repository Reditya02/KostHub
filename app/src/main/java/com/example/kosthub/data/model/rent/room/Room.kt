package com.example.kosthub.data.model.rent.room

import android.media.Rating
import android.os.Parcelable
import com.example.kosthub.data.model.rent.Thumbnail
import com.example.kosthub.data.model.rent.kost.Kost
import com.example.kosthub.data.model.user.Account
import com.example.kosthub.utils.PriceCategory
import com.example.kosthub.utils.RoomType
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Room(
    val id: Int,
    val rating: Rating,
    val roomType: RoomType,
    val owner: Account,
    val roomImage: String,
    val priceCategory: PriceCategory,
    val kost: Kost,
    val bathroom: Boolean,
    val description: String,
    val name: String,
    val roomNumber: String,
    val capacity: Int,
    val width: Double,
    val width2: Double,
    val price: Double,
    val isAvaliable: Boolean,
    val updatedDate: Date,
    val createddate: Date,
    val thumbnail: Thumbnail,
    val facilities: RoomFacilities
) : Parcelable
