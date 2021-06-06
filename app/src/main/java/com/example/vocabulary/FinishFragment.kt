package com.example.vocabulary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class FinishFragment : Fragment() {

    private var yourpoint: TextView? = null
    var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val rootView = inflater.inflate(R.layout.fragment_finish, container, false)

        yourpoint = rootView.findViewById(R.id.textView19)

        yourpoint!!.setText(StartFragment.point.toString())

        StartFragment.position = 0
        StartFragment.point = 0

        button = rootView.findViewById(R.id.button14)
        button!!.setOnClickListener{
            fragmentManager!!.beginTransaction()
                .add(R.id.frameLayout, StartFragment())
                .remove(this@FinishFragment)
                .commit()
        }


        return rootView
    }


    companion object {

    }
}