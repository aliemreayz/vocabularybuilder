package com.example.vocabulary

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_word.*
import java.util.ArrayList

class WordActivity : AppCompatActivity() {


    var wordsList = ArrayList<String>()
    var definitionList = ArrayList<String>()
    var sentenceList = ArrayList<String>()
    var synonymList = ArrayList<String>()
    var antonymList = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)



        val intent = intent
        val word = intent.getStringExtra("word")


        val veritabani = this.openOrCreateDatabase("Words", Context.MODE_PRIVATE, null)

        val cursor = veritabani.rawQuery("SELECT * FROM words WHERE word LIKE '%$word%'",null)

        val wordColumnIndex = cursor.getColumnIndex("word")
        val definitionColumnIndex = cursor.getColumnIndex("definition")
        val sentenceColumnIndex = cursor.getColumnIndex("sentence")
        val synonymColumnIndex = cursor.getColumnIndex("synonym")
        val antonymColumnIndex = cursor.getColumnIndex("antonym")



        wordsList.clear()
        definitionList.clear()
        sentenceList.clear()
        synonymList.clear()
        antonymList.clear()



        while(cursor.moveToNext()) {

            wordsList.add(cursor.getString(wordColumnIndex).toString())
            definitionList.add(cursor.getString(definitionColumnIndex).toString())
            sentenceList.add(cursor.getString(sentenceColumnIndex).toString())
            synonymList.add(cursor.getString(synonymColumnIndex).toString())
            antonymList.add(cursor.getString(antonymColumnIndex).toString())



        }

        cursor.close()







        textView.setText(word)
        textView8.setText(definitionList.get(0))
        textView13.setText(sentenceList.get(0))
        textView14.setText(synonymList.get(0))
        textView15.setText(antonymList.get(0))


    }
}