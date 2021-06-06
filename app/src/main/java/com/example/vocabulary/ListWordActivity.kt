package com.example.vocabulary

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_list_word.*
import kotlinx.android.synthetic.main.activity_word.*
import java.util.ArrayList

class ListWordActivity : AppCompatActivity() {


    var definitionList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_word)


        val intent = intent
        val word = intent.getStringExtra("word")


        val veritabani = this.openOrCreateDatabase("Words", Context.MODE_PRIVATE, null)

        val cursor = veritabani.rawQuery("SELECT * FROM words WHERE word LIKE '%$word%'",null)


        val definitionColumnIndex = cursor.getColumnIndex("definition")




        definitionList.clear()




        while(cursor.moveToNext()) {

            definitionList.add(cursor.getString(definitionColumnIndex).toString())




        }

        cursor.close()







        textView16.setText(word)
        textView21.setText(definitionList.get(0))

    }
}