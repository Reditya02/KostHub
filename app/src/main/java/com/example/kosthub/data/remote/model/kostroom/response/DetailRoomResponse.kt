package com.example.kosthub.data.remote.model.kostroom.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailRoomResponse(

	@field:SerializedName("another_room")
	val anotherRoom: List<AnotherRoomItem?>? = null,

	@field:SerializedName("addons_facilities")
	val addonsFacilities: List<AddonsFacilitiesItem?>? = null,

	@field:SerializedName("payment_scheme")
	val paymentScheme: List<PaymentSchemeItem?>? = null,

	@field:SerializedName("images")
	val images: Images? = null,

	@field:SerializedName("max_person")
	val maxPerson: String? = null,

	@field:SerializedName("rating")
	val rating: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("rules")
	val rules: List<RulesItem?>? = null,

	@field:SerializedName("label")
	val label: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("price")
	val price: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("location")
	val location: Location? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("facilities")
	val facilities: List<FacilitiesItem?>? = null
) : Parcelable

@Parcelize
data class KostItem(

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("url")
	val url: String? = null
) : Parcelable

@Parcelize
data class PaymentSchemeItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
) : Parcelable

@Parcelize
data class Location(

	@field:SerializedName("note")
	val note: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("province")
	val province: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("district")
	val district: String? = null,

	@field:SerializedName("long")
	val jsonMemberLong: String? = null,

	@field:SerializedName("lat")
	val lat: String? = null
) : Parcelable

@Parcelize
data class RoomItem(

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("url")
	val url: String? = null
) : Parcelable

@Parcelize
data class RulesItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
) : Parcelable

@Parcelize
data class AddonsFacilitiesItem(

	@field:SerializedName("price")
	val price: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
) : Parcelable

@Parcelize
data class Images(

	@field:SerializedName("kost")
	val kost: List<KostItem?>? = null,

	@field:SerializedName("room")
	val room: List<RoomItem?>? = null
) : Parcelable

@Parcelize
data class FacilitiesItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
) : Parcelable

@Parcelize
data class AnotherRoomItem(

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("price")
	val price: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("rating")
	val rating: String? = null,

	@field:SerializedName("location")
	val location: Location? = null,

	@field:SerializedName("id")
	val id: String? = null
) : Parcelable
