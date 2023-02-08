package com.example.kosthub.data.remote.model.kostroom.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AddKostRequest(

	@field:SerializedName("payment_scheme")
	val paymentScheme: List<Int>? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("additional_rule")
	val additionalRule: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("latitude")
	val latitude: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("rules")
	val rules: List<Int>? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("outdoor_photo")
	val outdoorPhoto: String? = null,

	@field:SerializedName("province")
	val province: String? = null,

	@field:SerializedName("district")
	val district: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("indoor_photo")
	val indoorPhoto: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("adress_note")
	val adressNote: String? = null,

	@field:SerializedName("longitude")
	val longitude: String? = null
) : Parcelable