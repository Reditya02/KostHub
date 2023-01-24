package com.example.kosthub.data.remote.model.user.request

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.File

@Parcelize
data class UpdateProfileRequest(
    val fullname: String,
    val birthdate: String,
    val gender: String,
    val occupation: String,
    val photo: File
) : Parcelable
