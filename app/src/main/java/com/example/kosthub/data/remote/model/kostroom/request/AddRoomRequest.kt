package com.example.kosthub.data.remote.model.kostroom.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AddRoomRequest(

	@field:SerializedName("addons_facilities")
	val addonsFacilities: List<AddFacilitiesItem?>? = null,

	@field:SerializedName("images")
	val images: List<String?>? = null,

	@field:SerializedName("bedroom_facilities")
	val bedroomFacilities: List<BedroomFacilitiesItem?>? = null,

	@field:SerializedName("quantity")
	val quantity: String? = null,

	@field:SerializedName("max_person")
	val maxPerson: String? = null,

	@field:SerializedName("price")
	val price: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("length")
	val length: String? = null,

	@field:SerializedName("width")
	val width: String? = null,

	@field:SerializedName("bathroom_facilities")
	val bathroomFacilities: List<BathroomFacilitiesItem?>? = null,

	@field:SerializedName("indoor_bathroom")
	val indoorBathroom: String? = null
) : Parcelable

@Parcelize
data class BedroomFacilitiesItem(

	@field:SerializedName("id")
	val id: String? = null
) : Parcelable

@Parcelize
data class AddFacilitiesItem(

	@field:SerializedName("price")
	val price: String? = null,

	@field:SerializedName("name")
	val name: String? = null
) : Parcelable

@Parcelize
data class BathroomFacilitiesItem(

	@field:SerializedName("id")
	val id: String? = null
) : Parcelable
