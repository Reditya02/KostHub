package com.example.kosthub.data.locale.bookmark

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "rooms")
@Parcelize
data class BookmarkRoom(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val email: String,
    val roomCard: String,
    val roomDetail: String
) : Parcelable
