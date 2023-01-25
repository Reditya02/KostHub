package com.example.kosthub.data.remote.model.kostroom.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BookingRequest(

	@field:SerializedName("addons_facilities")
	val addonsFacilities: List<AddonsFacilitiesItem?>? = null,

	@field:SerializedName("payment_scheme")
	val paymentScheme: String? = null,

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("kost_id")
	val kostId: String? = null,

	@field:SerializedName("capacity")
	val capacity: String? = null,

	@field:SerializedName("start_date")
	val startDate: String? = null
) : Parcelable

@Parcelize
data class AddonsFacilitiesItem(

	@field:SerializedName("id")
	val id: String? = null
) : Parcelable
