package com.example.kosthub.data.model.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserValidation(
    val id: Int,
    val idCardUrl: String,
    val type: String
) : Parcelable
