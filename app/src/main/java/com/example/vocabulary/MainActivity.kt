package com.example.vocabulary

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    var fm = supportFragmentManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {

            val veritabani = this.openOrCreateDatabase("Words", Context.MODE_PRIVATE, null)

            /*veritabani.execSQL("CREATE TABLE IF NOT EXISTS Categories (id INTEGER PRIMARY KEY, category VARCHAR)")
            veritabani.execSQL("INSERT INTO Categories(category) VALUES ('verbs')")
            veritabani.execSQL("INSERT INTO Categories(category) VALUES ('adverbs')")
            veritabani.execSQL("INSERT INTO Categories(category) VALUES ('adjectives')")
            veritabani.execSQL("INSERT INTO Categories(category) VALUES ('phrases and idioms')")


            veritabani.execSQL("CREATE TABLE IF NOT EXISTS UserWordType (id INTEGER PRIMARY KEY, userword VARCHAR)")
            veritabani.execSQL("INSERT INTO UserWordType(userword) VALUES ('it is not')")
            veritabani.execSQL("INSERT INTO UserWordType(userword) VALUES ('it is')")
            veritabani.execSQL("INSERT INTO UserWordType(userword) VALUES ('it is but not application')")


            veritabani.execSQL("CREATE TABLE IF NOT EXISTS Words (id INTEGER PRIMARY KEY, word VARCHAR, definition VARCHAR, categoryID VARCHAR, userwordID VARCHAR, sentence VARCHAR, synonym VARCHAR, antonym VARCHAR)")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('a dime a dozen', 'something common', '4', '1', 'Adventure and traveling based reality shows are now outdated and a dime a dozen', 'ordinary', 'rare')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('adore', 'love and respect (someone) deeply', '1', '1', 'Let us adore God for all his works', 'admire', 'hate')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('afford', 'have enough money to pay for', '1', '1', 'He will be able to afford a house next year', 'allow', 'have the means for')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('becoming', 'looking good on someone', '3', '2', 'She frowned, her voice becoming harsh', 'flattering', '')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('bend', 'shape or force (something straight) into a curve or angle', '1', '1', 'He was bending over to tie his shoelaces', 'curve', 'straighten')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('break a leg', 'good luck', '4', '1', 'I hope you break a leg at your job interview tomorrow', 'break down', 'follow')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('bright', 'giving out or reflecting much light; shining', '3', '1', 'Her eyes were a bright blue', 'shining', 'dark')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('call it a day', 'stop working on something', '4', '1', 'After 14 years living and working in this country, she thinks it is time to call it a day', '', 'keep on with')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('capable', 'having the ability, fitness, or quality necessary to do or achieve a specified thing', '3', '1', 'I always said he was the only man capable of defeating Napoleon', '', 'incompetent')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('clumsy', 'awkward in movement or in handling things', '3', '1', 'Her accent was still there, but the clumsy speech pattern was gone', 'bulky', 'graceful')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('consist', 'be composed or made up of', '1', '1', 'The lungs consist of millions of tiny air sacs', 'be made up', 'clash')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('coaxingly', 'To persuade or try to persuade by pleading or flattery; cajole', '2', '1', 'Mistress smiled kindly and coaxingly asked me to come over to her', 'blandishment', '')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('cruel', 'wilfully causing pain or suffering to others', '3', '1', 'The cruel man lashed the horse with his whip', 'brutal', 'compassionate')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('cut somebody some slack', 'do not be so critical', '4', '1', 'Kane is annoyed, but her parents decide to give her some slack', 'give someone some slack', 'criticize')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('daily', 'every day', '2', '1', 'The doctor recommended daily exercise', 'every day', 'sporadic')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('doubt', 'feel uncertain about', '1', '1', 'I doubt it was Pumpkin who left the money', '', '')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('eager', 'strongly wanting to do or have something', '3', '1', ' She waited in eager anticipation for Robert to arrive', 'anxious', 'uninterested')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('easy does it', 'slow down', '4', '1', 'Easy does it, guys, that’s a Verrocchio you are handling', 'easy to do', 'difficult')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('entirely', 'completely (often used for emphasis)', '2', '1', 'For the first time this week, she did not feel entirely doomed', 'completely', 'partially')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('fairly', 'with justice', '2', '1', 'I felt fairly easy after taking the medicine', 'justly', 'unfairly')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('forbid', 'refuse to allow (something)', '1', '1', 'Verb I forbid you to go', 'prohibit', 'permit')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('grimly', 'in a very serious, gloomy, or depressing manner', '2', '1', 'I look back grimly, but the difficulties to some extent have been increased', 'aggressively', 'favorably')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('hit the sack', 'go to sleep', '4', '1', 'I am really tired after all that exercise. I am going to hit the sack', '', 'get up')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('huge', 'extremely large; enormous', '3', '1', 'She lives in a huge house', 'enormous', 'tiny')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('in', 'inside a container, place, or area, or surrounded or closed off by something', '4', '1', 'I am not saying we live in a utopia', 'inside', 'outside')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('indicate', 'point out; show', '1', '1', 'Expense does not necessarily indicate worth', 'designate', '')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('lay', 'put (something) down gently or carefully', '1', '1', 'I lay the baby in the cradle', 'put', 'pick up')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('loudly', 'in a way that produces much noise', '2', '1', 'Her stomach grumbled loudly again', 'noisily', 'quietly')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('miss the boat', 'it is too late', '4', '1', 'The buyer missed the boat and never got the house when he offered too low a bid', '', '')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('muscular', 'relating to or affecting the muscles', '3', '1', 'He is tall, broad and muscular', 'fibrous', 'skinny')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('nearby', 'close by', '2', '1', 'I sat nearby but my wait was brief', 'close by', 'faraway')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('notably', 'in particular; especially', '2', '2', 'The film is plot was notably lacking', 'in particular', '')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('on','used to indicate that something is attached to, covering, or supported by something else', '4', '1', 'A warm hand rested on her waist', '', '')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('petite', 'attractively small and dainty (used of a woman)', '3', '1', 'All of my possessions are multipurpose and petite', 'small', 'large')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('suggest', 'put forward for consideration', '1', '1', 'I suggest we go out to eat', 'propose', 'disadvise')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('seldom', 'not often; rarely', '2', '1', 'She was seldom late for work', 'rarely', 'often')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('soon', 'in or after a short time', '2', '1', 'The ship sailed away and was soon lost to sight', 'shortly', '')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('uptight', 'anxious or angry in a tense and overly controlled way', '3', '1', 'Tonight he is manic, wired and uptight', 'anxious', 'unlax')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('under the weather', 'sick', '4', '1', 'I have my final exam today, but I am feeling under the weather', 'ill', 'healthful')")
            veritabani.execSQL("INSERT INTO Words(word, definition, categoryID, userwordID, sentence, synonym, antonym) VALUES ('vanish', 'disappear suddenly and completely', '1', '1', 'All your troubles will vanish away when he returns safely', 'disappear', 'appear')")

            veritabani.execSQL("CREATE TABLE IF NOT EXISTS WordToRemember (id INTEGER PRIMARY KEY, word VARCHAR, definition VARCHAR)")

            */




            /*val cursor = veritabani.rawQuery("SELECT * FROM words",null)
            val idColumnIndex = cursor.getColumnIndex("id")
            val wordColumnIndex = cursor.getColumnIndex("word")
            val categoryColumnIndex = cursor.getColumnIndex("categoryID")
            val userwordColumnIndex = cursor.getColumnIndex("userwordID")


            //wordsList.clear()

            while(cursor.moveToNext()) {
                println("ID: ${cursor.getInt(idColumnIndex)}")
                println("WORD: ${cursor.getString(wordColumnIndex)} ")
                //wordsList.add(cursor.getString(wordColumnIndex).toString())
                println("CATEGORY: ${cursor.getInt(categoryColumnIndex)} ")
                println("USERWORD: ${cursor.getInt(userwordColumnIndex)} ")

            }

            cursor.close()*/










        }catch (e: Exception){
            e.printStackTrace()<
        }




        var calendar = Calendar.getInstance()
        var calendar2 = Calendar.getInstance()

        calendar.set(Calendar.HOUR_OF_DAY, 10)
        calendar.set(Calendar.MINUTE,43)
        calendar.set(Calendar.SECOND,5)


        calendar2.set(Calendar.HOUR_OF_DAY, 15)
        calendar2.set(Calendar.MINUTE,44)
        calendar2.set(Calendar.SECOND,5)



        val intent = Intent(this, Notification_reciever::class.java)
        val intent2 = Intent(this, Notification_reciever2::class.java)

        val pendingIntent = PendingIntent.getBroadcast(this, 100, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val pendingIntent2 = PendingIntent.getBroadcast(this, 200, intent2, PendingIntent.FLAG_UPDATE_CURRENT)

        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager


        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, AlarmManager.INTERVAL_DAY, pendingIntent)
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar2.timeInMillis, AlarmManager.INTERVAL_DAY, pendingIntent2)















    }




    fun words(view: View){
        val intent = Intent(applicationContext, CategoriesActivity::class.java)
        startActivity(intent)
    }


    fun quiz(view: View){
        val intent = Intent(applicationContext, QuizActivity::class.java)
        startActivity(intent)
    }

    fun change(view: View){
        val intent = Intent(applicationContext, ListActivity::class.java)
        startActivity(intent)
    }


    companion object{
        var wordsList = ArrayList<String>()
    }

}