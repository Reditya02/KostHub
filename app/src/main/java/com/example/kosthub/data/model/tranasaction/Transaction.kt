package com.example.kosthub.data.model.tranasaction

import android.accounts.Account
import android.os.Parcelable
import com.example.kosthub.data.model.rent.room.Room
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Transaction(
    val id: Int,
    val tenant: Account,
    val room: Room,
    val paymentMehod: Payment,
    val numPeople: Int,
    val date: Date,
    val startRent: Date,
    val price: Double,
    val status: Char,
    val rentalDuration: Int,
    val rentalSchema: String,
    val urlDocument: String,
    val isDelete: Boolean,
    val createdDate: Date,
    val updatedDate: Date
) : Parcelable