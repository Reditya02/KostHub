package com.example.kosthub.data.model.user

import android.os.Parcelable
import com.example.kosthub.utils.Role
import kotlinx.parcelize.Parcelize

@Parcelize
data class Account(
    val accountId: Int,
    val phoneNumber: String,
    val email: String,
    val verify: Boolean,
    val userProfile: UserProfile,
    val role: Role,
    val userBank: UserBank,
    val userValidation: UserValidation
) : Parcelable
