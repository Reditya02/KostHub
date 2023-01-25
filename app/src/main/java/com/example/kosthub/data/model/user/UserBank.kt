package com.example.kosthub.data.model.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserBank(
    val id: Int,
    val user: Account,
    val bankName: String,
    val accountNumber: String,
    val branchBank: String
) : Parcelable