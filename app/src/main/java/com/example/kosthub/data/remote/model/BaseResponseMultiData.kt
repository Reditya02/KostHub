package com.example.kosthub.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class BaseResponseMultiData<T>(
    @field:SerializedName("data")
    val data: @RawValue List<T>? = null,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("error")
    val error: String? = null
) : Parcelable
