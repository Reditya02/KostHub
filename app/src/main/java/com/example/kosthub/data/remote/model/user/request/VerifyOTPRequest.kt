package com.example.kosthub.data.remote.model.user.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class VerifyOTPRequest(

	@field:SerializedName("code")
	val code: String,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("email")
	val email: String? = null
) : Parcelable
