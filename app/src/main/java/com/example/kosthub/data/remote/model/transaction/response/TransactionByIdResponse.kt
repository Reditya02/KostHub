package com.example.kosthub.data.remote.model.transaction.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TransactionByIdResponse(

	@field:SerializedName("tf_end_date")
	val tfEndDate: String,

	@field:SerializedName("price")
	val price: String,

	@field:SerializedName("id")
	val id: String
) : Parcelable
