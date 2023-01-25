package com.example.kosthub.data.remote.model.user.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChangePasswordRequest(

	@field:SerializedName("password")
	val password: String,

	@field:SerializedName("new_password")
	val newPassword: String
) : Parcelable
