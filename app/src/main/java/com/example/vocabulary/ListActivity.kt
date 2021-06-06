package com.example.vocabulary

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_words.*

import java.util.ArrayList

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)



        val veritabani = this.openOrCreateDatabase("Words", Context.MODE_PRIVATE, null)

        var cursor = veritabani.rawQuery("SELECT word FROM Words WHERE userwordID = 2 or userwordID = 3", null)



        val wordColumnIndex = cursor.getColumnIndex("word")




        wordList.clear()

        while(cursor.moveToNext()) {
            println("WORD: ${cursor.getString(wordColumnIndex)}")

            wordList.add(cursor.getString(wordColumnIndex).toString())

        }

        val layoutManager = LinearLayoutManager(this)
        recyclerView3.layoutManager = layoutManager

        val adapter = RecyclerAdapter3(wordList)
        recyclerView3.adapter = adapter

        this?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {



            override fun handleOnBackPressed() {
                // in here you can do logic when backPress is clicked



                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        }
        )



    }

    fun add(view : View){

        var entered_word = editTextWord.text.toString()
        var entered_definition = editTextDefinition.text.toString()

        if(entered_word != "" && entered_definition != ""){
            val veritabani = this.openOrCreateDatabase("Words", Context.MODE_PRIVATE, null)

            veritabani.execSQL("INSERT INTO Words (word, definition, userwordID) VALUES ('$entered_word', '$entered_definition', 3)")

            val intent = Intent(applicationContext, ListActivity::class.java)
            startActivity(intent)

        }


    }



    companion object{
        var wordList = ArrayList<String>()
    }
}