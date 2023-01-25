package com.example.kosthub.data.locale.bookmark

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BookmarkDao {
    @Query("select * from rooms where email like :email")
    fun getAllRoom(email: String): List<BookmarkRoom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveBookmark(room: BookmarkRoom)
}