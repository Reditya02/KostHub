package com.example.kosthub.data.remote.model.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RequestOTPRequest(

	@field:SerializedName("email?")
	val email: String? = null,

	@field:SerializedName("phone?")
	val phone: String? = null
) : Parcelable
