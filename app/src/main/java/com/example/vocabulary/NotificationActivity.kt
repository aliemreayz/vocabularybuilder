package com.example.vocabulary

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.system.exitProcess

class NotificationActivity : AppCompatActivity() {

    private val random = Random()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)


        val btnMemorized = findViewById<Button>(R.id.button9)
        val btnCancel = findViewById<Button>(R.id.button10)
        val textWord = findViewById<TextView>(R.id.textView11)
        val textWord2 = findViewById<TextView>(R.id.textView12)

        var listMe = "";
        var listDe = "";

        val veritabani = this.openOrCreateDatabase("Words", Context.MODE_PRIVATE, null)


        var cursor = veritabani.rawQuery(
            "SELECT word FROM Words WHERE userwordID = 2 or userwordID = 3",
            null
        )
        val wordColumnIndex = cursor.getColumnIndex("word")

        val list = ArrayList<String>()
        list.clear()

        while (cursor.moveToNext()) {
            list.add(cursor.getString(wordColumnIndex).toString())
        }

        cursor.close()


        var cursorMem = veritabani.rawQuery("SELECT * FROM WordToRemember", null)

        val wordMemColumnIndex = cursorMem.getColumnIndex("word")
        val definitionMemColumnIndex = cursorMem.getColumnIndex("definition")

        val listMem = ArrayList<String>()
        val listDef = ArrayList<String>()

        listMem.clear()
        listDef.clear()

        while (cursorMem.moveToNext()) {
            listMem.add(cursorMem.getString(wordMemColumnIndex))
            listDef.add(cursorMem.getString(definitionMemColumnIndex))
        }

        cursorMem.close()



        if (listMem.isEmpty()) {

            val rnd = random.nextInt(list.size)

            listMem.add(list.get(rnd))
            listMe = listMem.get(0)


            var cursorMem = veritabani.rawQuery(
                "SELECT definition FROM Words WHERE word LIKE '%$listMe%'",
                null
            )
            val definitionColumnIndex = cursorMem.getColumnIndex("definition")
            val listDef = ArrayList<String>()

            listDef.clear()

            while (cursorMem.moveToNext()) {
                listDef.add(cursorMem.getString(definitionColumnIndex).toString())
            }

            cursorMem.close()

            listDe = listDef.get(0)

            veritabani.execSQL("INSERT INTO WordToRemember (word, definition)   VALUES('$listMe', '$listDe') ")

            textWord.setText(listMem.get(0))
            textWord2.setText(listDef.get(0))



            btnMemorized.setOnClickListener {

                val deleteWord = listMem.get(0)

                var rnd = random.nextInt(list.size)

                while (listMem.get(0) == list.get(rnd)) {
                    rnd = random.nextInt(list.size)
                }

                listMem.clear()
                listMem.add(list.get(rnd))
                listMe = listMem.get(0)


                var cursorMem = veritabani.rawQuery(
                    "SELECT definition FROM Words WHERE word LIKE '%$listMe%'",
                    null
                )
                val definitionColumnIndex = cursorMem.getColumnIndex("definition")
                val listDef = ArrayList<String>()

                listDef.clear()

                while (cursorMem.moveToNext()) {
                    listDef.add(cursorMem.getString(definitionColumnIndex).toString())
                }

                cursorMem.close()


                listMe = listMem.get(0)
                listDe = listDef.get(0)

                veritabani.execSQL("UPDATE WordToRemember SET word = '$listMe' WHERE  id = 1  ")
                veritabani.execSQL("UPDATE WordToRemember SET definition = '$listDe' WHERE  id = 1  ")


                val intent = Intent(applicationContext, DeleteActivity::class.java)
                intent.putExtra("word",deleteWord)
                startActivity(intent)

            }

            btnCancel.setOnClickListener {
                exitProcess(1)
            }


        } else {

            textWord.setText(listMem.get(0))
            textWord2.setText(listDef.get(0))


            btnMemorized.setOnClickListener {

                val deleteWord = listMem.get(0)

                var rnd = random.nextInt(list.size)

                while (listMem.get(0) == list.get(rnd)) {
                    rnd = random.nextInt(list.size)
                }

                listMem.clear()
                listMem.add(list.get(rnd))
                listMe = listMem.get(0)


                var cursorMem = veritabani.rawQuery(
                    "SELECT definition FROM Words WHERE word LIKE '%$listMe%'",
                    null
                )
                val definitionColumnIndex = cursorMem.getColumnIndex("definition")
                val listDef = ArrayList<String>()

                listDef.clear()

                while (cursorMem.moveToNext()) {
                    listDef.add(cursorMem.getString(definitionColumnIndex).toString())
                }

                cursorMem.close()


                listMe = listMem.get(0)
                listDe = listDef.get(0)

                veritabani.execSQL("UPDATE WordToRemember SET word = '$listMe' WHERE  id = 1  ")
                veritabani.execSQL("UPDATE WordToRemember SET definition = '$listDe' WHERE  id = 1  ")

                val intent = Intent(applicationContext, DeleteActivity::class.java)
                intent.putExtra("word",deleteWord)
                startActivity(intent)
            }

            btnCancel.setOnClickListener {
                exitProcess(1)
            }

        }

    }
}