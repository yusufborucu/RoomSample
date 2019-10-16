package com.yusufborucu.roomsample

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "book")
class Book {
    @PrimaryKey(autoGenerate = true)
    var bookId: Int = 0

    @ColumnInfo(name = "name")
    var name: String = ""

    @ColumnInfo(name = "author")
    var author: String = ""

    @ColumnInfo(name = "pageCount")
    var pageCount: Int = 0
}