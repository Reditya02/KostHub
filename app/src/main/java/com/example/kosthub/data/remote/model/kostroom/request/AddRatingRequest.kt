package com.example.kosthub.data.remote.model.kostroom.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AddRatingRequest(

	@field:SerializedName("room_id")
	val roomId: String,

	@field:SerializedName("review")
	val review: String,

	@field:SerializedName("rating")
	val rating: String,

	@field:SerializedName("anonym")
	val anonym: String
) : Parcelable
