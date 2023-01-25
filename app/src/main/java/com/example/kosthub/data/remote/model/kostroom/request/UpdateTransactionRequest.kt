package com.example.kosthub.data.remote.model.kostroom.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UpdateTransactionRequest(

	@field:SerializedName("status")
	val status: String? = null
) : Parcelable
