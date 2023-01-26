package com.example.kosthub.data.remote.model.user.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailUserResponse(

	@field:SerializedName("bank")
	val bank: Bank? = null,

	@field:SerializedName("birthdate")
	val birthdate: String? = null,

	@field:SerializedName("occupation")
	val occupation: String? = null,

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("verified")
	val verified: String? = null,

	@field:SerializedName("photo")
	val photo: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("fullname")
	val fullname: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("verification")
	val verification: Verification? = null
) : Parcelable

@Parcelize
data class Verification(

	@field:SerializedName("photo")
	val photo: String? = null,

	@field:SerializedName("type")
	val type: String? = null
) : Parcelable

@Parcelize
data class Bank(

	@field:SerializedName("account_number")
	val accountNumber: String? = null,

	@field:SerializedName("account_name")
	val accountName: String? = null,

	@field:SerializedName("bank_name")
	val bankName: String? = null
) : Parcelable
