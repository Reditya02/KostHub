package com.example.kosthub.data.locale.bookmark

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class BookmarkDatabase : RoomDatabase() {
    abstract fun bookmarkDao(): BookmarkDao

    companion object {
        @Volatile
        private var INSTANCE: BookmarkDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): BookmarkDatabase {
            if (INSTANCE == null) {
                synchronized(BookmarkDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        BookmarkDatabase::class.java,
                        "rooms"
                    ).build()
                }
            }
            return INSTANCE as BookmarkDatabase
        }
    }
}