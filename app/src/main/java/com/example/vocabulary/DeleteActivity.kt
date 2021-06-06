package com.example.vocabulary

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class DeleteActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_delete)

        val intent = intent
        val word = intent.getStringExtra("word")

        val veritabani = this.openOrCreateDatabase("Words", Context.MODE_PRIVATE, null)
        veritabani.execSQL("UPDATE Words SET userwordID = 1 WHERE  word LIKE '%$word%' and userwordID = 2")
        veritabani.execSQL("DELETE FROM Words WHERE  word LIKE '%$word%' and userwordID = 3")


        val intent1 = Intent(applicationContext, ListActivity::class.java)
        startActivity(intent1)





    }

    companion object{

    }
}