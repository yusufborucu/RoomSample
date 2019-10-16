package com.yusufborucu.roomsample

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Book::class], version = 1)
abstract class DatabaseManager : RoomDatabase() {

    abstract fun bookDao(): BookDao

    companion object {
        var INSTANCE: DatabaseManager ?= null

        fun getDatabaseManager(context: Context): DatabaseManager? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseManager::class.java,
                    "book-database"
                ).allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}