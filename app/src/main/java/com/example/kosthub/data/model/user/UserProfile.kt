package com.example.kosthub.data.model.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class UserProfile(
    val id: Int,
    val account: Account,
    val fullname : String,
    val birthDate: Date,
    val address: String,
    val gender: String,
    val job: String,
    val urlPhoto: String,
    val createdDate: Date,
    val updateDate: Date,
    val isDeleted: Boolean
) : Parcelable
