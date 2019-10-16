package com.yusufborucu.roomsample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var databaseManager: DatabaseManager ?= null
    val books: MutableList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databaseManager = DatabaseManager.getDatabaseManager(this)

        val bookList = getAllBooks()
        bookList!!.forEach {
            books.add(it.name + " - " + it.author + " - " + it.pageCount + " sayfa")
        }

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, books)
        lvBooks.adapter = adapter

        fabAdd.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun getAllBooks(): List<Book>? {
        return databaseManager?.bookDao()?.getAllBooks()
    }
}
