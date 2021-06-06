package com.example.vocabulary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout

class QuizActivity : AppCompatActivity() {


    var fm = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        showStart()
    }

    fun showStart(){
        val ft = fm.beginTransaction()
        ft.add(R.id.frameLayout, StartFragment())
        ft.commit()
    }

}