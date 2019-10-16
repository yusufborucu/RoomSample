package com.yusufborucu.roomsample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    var databaseManager: DatabaseManager ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        databaseManager = DatabaseManager.getDatabaseManager(this)

        bSave.setOnClickListener {
            val name = etName.text.toString()
            val author = etAuthor.text.toString()
            val page = etPage.text.toString()

            insertBook(name, author, page.toInt())

            Toast.makeText(applicationContext, "Kitap başarıyla kaydedildi.", Toast.LENGTH_SHORT).show()

            etName.setText("")
            etAuthor.setText("")
            etPage.setText("")
        }
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun insertBook(name: String, author: String, page: Int) {
        val book = Book()
        book.name = name
        book.author = author
        book.pageCount = page
        databaseManager?.bookDao()?.addBook(book)
    }
}
