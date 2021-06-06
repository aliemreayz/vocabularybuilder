    package com.example.vocabulary

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_categories.*
import kotlinx.android.synthetic.main.activity_categories.recyclerView
import kotlinx.android.synthetic.main.activity_words.*
import java.util.ArrayList

class WordsActivity : AppCompatActivity() {

    var fm = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words)

        val intent = this.intent
        val controlcategory = intent.getStringExtra("category")



        if(controlcategory != null){
            category = intent.getStringExtra("category")
        }





        val veritabani = this.openOrCreateDatabase("Words", Context.MODE_PRIVATE, null)

        var cursor = veritabani.rawQuery("SELECT word FROM Words WHERE categoryID = 5", null)

        if(category == "verbs") {
            cursor = veritabani.rawQuery("SELECT word FROM Words WHERE categoryID = 1", null)
        }
        else if(category == "adverbs"){
            cursor = veritabani.rawQuery("SELECT word FROM Words WHERE categoryID = 2", null)
        }
        else if(category == "adjectives"){
            cursor = veritabani.rawQuery("SELECT word FROM Words WHERE categoryID = 3", null)
        }
        else if(category == "phrases and idioms"){
            cursor = veritabani.rawQuery("SELECT word FROM Words WHERE categoryID = 4", null)
        }

        val wordColumnIndex = cursor.getColumnIndex("word")




        wordList.clear()

        while(cursor.moveToNext()) {


            wordList.add(cursor.getString(wordColumnIndex).toString())

        }

        cursor.close()









        val layoutManager = LinearLayoutManager(this)
        recyclerView2.layoutManager = layoutManager

        val adapter = RecyclerAdapter2(WordsActivity.wordList)
        recyclerView2.adapter = adapter










    }

    



    companion object{
        var wordList = ArrayList<String>()
        var category : String? = null

    }


}