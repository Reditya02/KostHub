package com.example.kosthub.data.model.rent.room

import android.accounts.Account
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ratings(
    val id: Int,
    val rating: Int,
    val account: Account,
    val room: Room
) : Parcelable