package com.example.kosthub.data.locale.bookmark

import androidx.room.*

@Dao
interface BookmarkDao {
    @Query("select * from rooms where email like :email")
    suspend fun getAllRoom(email: String): List<BookmarkRoom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveBookmark(room: BookmarkRoom)

    @Delete
    fun deleteBookmark(room: BookmarkRoom)
}