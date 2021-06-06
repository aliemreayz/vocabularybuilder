package com.example.vocabulary

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*


class QuizFragment : Fragment() {

    private var question: TextView? = null
    private var option1: TextView? = null
    private var option2: TextView? = null
    private var option3: TextView? = null
    private var option4: TextView? = null
    var selectedCat : String ?= null
    private val random = Random()
    private var pointInd: TextView? = null
    private var questionInd: TextView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_quiz, container, false)


        question = rootView.findViewById(R.id.textView4)
        option1 = rootView.findViewById(R.id.button5)
        option2 = rootView.findViewById(R.id.button11)
        option3 = rootView.findViewById(R.id.button12)
        option4 = rootView.findViewById(R.id.button13)
        pointInd = rootView.findViewById(R.id.textView6)
        questionInd = rootView.findViewById(R.id.textView5)

        val answer = StartFragment.list.get(StartFragment.position)

        val veritabani = activity!!.openOrCreateDatabase("Words", Context.MODE_PRIVATE, null)

        val cursor = veritabani.rawQuery("SELECT * FROM words  WHERE  word LIKE '%$answer%' ",null)
        val definitionColumnIndex = cursor.getColumnIndex("definition")


        while(cursor.moveToNext()) {
            println("DEFINITION: ${cursor.getString(definitionColumnIndex)} ")
            question!!.setText("${cursor.getString(definitionColumnIndex)}")
        }

        val options: ArrayList<String> = ArrayList<String>()



        options.add(answer)



        while(options.size!=4){
            val rnd = random.nextInt(10)

            while(StartFragment.list.get(rnd) != answer && !(StartFragment.list.get(rnd)in options)){

                options.add(StartFragment.list.get(rnd))
                break
            }

        }

        Collections.shuffle(options)



        pointInd!!.setText(StartFragment.point.toString())
        questionInd!!.setText("Question ${(StartFragment.position+1).toString()}")


        option1!!.setText(options[0])
        option2!!.setText(options[1])
        option3!!.setText(options[2])
        option4!!.setText(options[3])



        option1!!.setOnClickListener{
            check(options[0])
        }
        option2!!.setOnClickListener{
            check(options[1])
        }
        option3!!.setOnClickListener{
            check(options[2])
        }
        option4!!.setOnClickListener{
            check(options[3])
        }


        return rootView
    }


    fun check(selectedAnswer: String?){


        if(StartFragment.position == 9){

            StartFragment.position = 0


            fragmentManager!!.beginTransaction()
                .add(R.id.frameLayout, FinishFragment())
                .remove(this@QuizFragment)
                .commit()
        }
        else {
            if (StartFragment.list!!.get(StartFragment.position) == selectedAnswer) {
                StartFragment.point++
            }

            StartFragment.position++

            println("POINT: ${StartFragment.point}")

            fragmentManager!!.beginTransaction()
                .add(R.id.frameLayout, QuizFragment())
                .remove(this@QuizFragment)
                .commit()

        }


        /*if (StartFragment.list!!.get(StartFragment.position) == answer) {



            StartFragment.position++
            StartFragment.counter++
            StartFragment.point++

            if (StartFragment.counter == 10) {


                replace()

            } else {

                refresh()
            }
        } else {
            MainActivity.mp.stop()
            MainActivity.t1!!.speak("im sorry, wrong answer", TextToSpeech.QUEUE_FLUSH,null,)
            val intent = Intent (getActivity(), result::class.java)
            val str:String = MainActivity.point.toString()
            intent.putExtra("point", str);
            getActivity()?.startActivity(intent)
        }*/
    }






    companion object {

    }
}