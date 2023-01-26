package com.example.kosthub.data.locale.bookmark

import android.os.Parcelable
import com.example.kosthub.data.remote.model.kostroom.response.DetailRoomResponse
import com.example.kosthub.data.remote.model.kostroom.response.SearchRoomResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class RoomData(
    val roomCard: SearchRoomResponse,
    val roomDetail: DetailRoomResponse
) : Parcelable
