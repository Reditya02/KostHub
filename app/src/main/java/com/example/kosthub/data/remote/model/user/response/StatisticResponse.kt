package com.example.kosthub.data.remote.model.user.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class StatisticResponse(

	@field:SerializedName("bookers")
	val bookers: Int,

	@field:SerializedName("empty_rooms")
	val emptyRooms: Int,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("occupants")
	val occupants: Int
) : Parcelable
