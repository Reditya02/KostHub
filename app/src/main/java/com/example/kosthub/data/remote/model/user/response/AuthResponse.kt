package com.example.kosthub.data.remote.model.user.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AuthResponse(

	@field:SerializedName("access_token")
	val accessToken: String? = null,

	@field:SerializedName("user_details")
	val userDetails: UserDetails? = null
) : Parcelable

@Parcelize
data class Role(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: String? = null
) : Parcelable

@Parcelize
data class UserDetails(

    @field:SerializedName("birthdate")
    val birthdate: String? = null,

    @field:SerializedName("occupation")
    val occupation: String? = null,

    @field:SerializedName("role")
    val role: Role? = null,

    @field:SerializedName("gender")
    val gender: String? = null,

    @field:SerializedName("phone")
    val phone: String? = null,

    @field:SerializedName("verified")
    val verified: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("fullname")
    val fullname: String? = null,

    @field:SerializedName("email")
    val email: String? = null
) : Parcelable