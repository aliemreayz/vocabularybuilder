package com.example.vocabulary

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_categories.*
import kotlinx.android.synthetic.main.recycler_row.*
import java.util.ArrayList


class CategoriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        var categoryList = ArrayList<String>()

        val veritabani = this.openOrCreateDatabase("Words", Context.MODE_PRIVATE, null)

        val cursor = veritabani.rawQuery("SELECT * FROM Categories", null)
        //val idColumnIndex = cursor.getColumnIndex("id")
        val categoryColumnIndex = cursor.getColumnIndex("category")



        categoryList.clear()

        while(cursor.moveToNext()) {
            //println("ID: ${cursor.getInt(idColumnIndex)}")
            //println("CATEGORY: ${cursor.getString(categoryColumnIndex)} ")
            categoryList.add(cursor.getString(categoryColumnIndex).toString())

        }

        cursor.close()


        //println(categoryList)


        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val adapter = RecyclerAdapter(categoryList)
        recyclerView.adapter = adapter

    }


}