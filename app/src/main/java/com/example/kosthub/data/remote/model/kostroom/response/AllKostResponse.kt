package com.example.kosthub.data.remote.model.kostroom.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AllKostResponse(

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("address")
	val address: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("label")
	val label: String,

	@field:SerializedName("type")
	val type: String
) : Parcelable
