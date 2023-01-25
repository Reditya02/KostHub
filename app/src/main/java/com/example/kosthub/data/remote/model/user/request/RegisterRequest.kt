package com.example.kosthub.data.remote.model.user.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RegisterRequest(

	@field:SerializedName("password")
	val password: String,

	@field:SerializedName("phone")
	val phone: String,

	@field:SerializedName("email")
	val email: String
) : Parcelable
