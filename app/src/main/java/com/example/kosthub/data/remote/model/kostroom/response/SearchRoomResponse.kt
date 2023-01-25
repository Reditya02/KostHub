package com.example.kosthub.data.remote.model.kostroom.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchRoomResponse(

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("price")
	val price: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("rating")
	val rating: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("label")
	val label: String? = null,

	@field:SerializedName("type")
	val type: String? = null
) : Parcelable
