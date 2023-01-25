package com.example.kosthub.data.remote.model.user.request

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.File

@Parcelize
data class UpdateIdentityRequest(
    val email: String,
    val phone: String,
    val type: String,
    val photo: File
): Parcelable
