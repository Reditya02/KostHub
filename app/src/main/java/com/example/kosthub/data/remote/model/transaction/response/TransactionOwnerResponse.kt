package com.example.kosthub.data.remote.model.transaction.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TransactionOwnerResponse(

	@field:SerializedName("account_created_date")
	val accountCreatedDate: String? = null,

	@field:SerializedName("room_name")
	val roomName: String? = null,

	@field:SerializedName("room_thumbnail")
	val roomThumbnail: String? = null,

	@field:SerializedName("room_label")
	val roomLabel: String? = null,

	@field:SerializedName("price")
	val price: String? = null,

	@field:SerializedName("room_address")
	val roomAddress: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("created_date")
	val createdDate: String? = null,

	@field:SerializedName("room_type")
	val roomType: String? = null
) : Parcelable
