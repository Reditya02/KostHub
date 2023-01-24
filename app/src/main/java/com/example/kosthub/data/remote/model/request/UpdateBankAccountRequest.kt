package com.example.kosthub.data.remote.model.request

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UpdateBankAccountRequest(
	val accountNumber: String? = null,
	val accountName: String? = null,
	val bankName: String? = null
) : Parcelable
