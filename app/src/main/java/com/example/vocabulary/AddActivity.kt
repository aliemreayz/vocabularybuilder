package com.example.vocabulary

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val intent = this.intent
        val word = intent.getStringExtra("word")

        val veritabani = this.openOrCreateDatabase("Words", Context.MODE_PRIVATE, null)

        veritabani.execSQL("UPDATE Words SET userwordID = 2 WHERE  word LIKE '%$word%' ")

        finish()
    }
}