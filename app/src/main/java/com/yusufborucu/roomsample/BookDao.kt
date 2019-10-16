package com.yusufborucu.roomsample

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface BookDao {

    @Query("SELECT * FROM book")
    fun getAllBooks(): List<Book>

    @Insert
    fun addBook(book: Book)
}