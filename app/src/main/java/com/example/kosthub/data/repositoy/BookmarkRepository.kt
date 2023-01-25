package com.example.kosthub.data.repositoy

import com.example.kosthub.data.locale.auth.AuthPreferences
import com.example.kosthub.data.locale.bookmark.BookmarkDao
import com.example.kosthub.data.locale.bookmark.BookmarkRoom
import com.example.kosthub.data.locale.bookmark.RoomData
import com.example.kosthub.data.remote.ApiService
import com.example.kosthub.data.remote.model.kostroom.response.DetailRoomResponse
import com.example.kosthub.data.remote.model.kostroom.response.SearchRoomResponse
import com.google.gson.Gson
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Inject

class BookmarkRepository @Inject constructor(
    private val apiService: ApiService,
    private val bookmarkDao: BookmarkDao,
    private val pref: AuthPreferences
) {
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    suspend fun getAllRoom(email: String) = bookmarkDao.getAllRoom(email).map {
        RoomData(
            roomCard = Gson().fromJson(
                it.roomCard,
                SearchRoomResponse::class.java
            ),
            roomDetail = Gson().fromJson(
                it.roomDetail,
                DetailRoomResponse::class.java
            )
        )
    }

    suspend fun saveRoom(room: RoomData) = executorService.execute {
        val roomCard = Gson().toJson(room.roomCard)
        val roomDetail = Gson().toJson(room.roomDetail)
        val data = BookmarkRoom(
            email = pref.getUser().email ?: "",
            roomCard = roomCard,
            roomDetail = roomDetail
        )
        bookmarkDao.saveBookmark(data)
    }
}