package com.example.vocabulary

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_start.*
import java.util.*
import kotlin.collections.ArrayList


class StartFragment : Fragment() {

    var button: Button? = null
    var spinner : Spinner? = null
    var arrayAdapter : ArrayAdapter<String> ? = null
    var category = ArrayList<String>()
    var selectedCat : String ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_start, container, false)
        // Inflate the layout for this fragment

        spinner = rootView.findViewById(R.id.spinner)
        category.add("verbs")
        category.add("adverbs")
        category.add("adjectives")
        category.add("phrases and idioms")



        arrayAdapter = ArrayAdapter(activity!!,android.R.layout.simple_spinner_item,category)

        spinner!!.setAdapter(arrayAdapter)






        button = rootView.findViewById(R.id.button6)
        button?.setOnClickListener(){

            selected = spinner!!.getSelectedItem().toString();

            if(selected == "verbs")
                selectedCat = "1"
            else if(selected == "adverbs")
                selectedCat = "2"
            else if(selected == "adjectives")
                selectedCat = "3"
            else
                selectedCat = "4"

            val veritabani = activity!!.openOrCreateDatabase("Words", Context.MODE_PRIVATE, null)

            val cursor = veritabani.rawQuery("SELECT * FROM words  WHERE  categoryID LIKE '%$selectedCat%' ",null)
            val idColumnIndex = cursor.getColumnIndex("id")
            val wordColumnIndex = cursor.getColumnIndex("word")
            val definitionColumnIndex = cursor.getColumnIndex("definition")
            val categoryColumnIndex = cursor.getColumnIndex("categoryID")
            val userwordColumnIndex = cursor.getColumnIndex("userwordID")


            list.clear()

            while(cursor.moveToNext()) {
                //println("ID: ${cursor.getInt(idColumnIndex)}")
                //println("WORD: ${cursor.getString(wordColumnIndex)} ")
                list.add(cursor.getString(wordColumnIndex).toString())
                //println("CATEGORY: ${cursor.getInt(categoryColumnIndex)} ")
                //println("USERWORD: ${cursor.getInt(userwordColumnIndex)} ")

            }


            Collections.shuffle(list)

            fragmentManager!!.beginTransaction()
                .add(R.id.frameLayout, QuizFragment())
                .remove(this@StartFragment)
                .commit()
        }

        return rootView
    }

    companion object {
        var selected : String? = null
        var list = ArrayList<String>()
        var position = 0

        var point = 0
    }
}