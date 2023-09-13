package com.example.datachallenge.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.datachallenge.R



class DataFragment : Fragment() {
 lateinit var v : View;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
     v = inflater.inflate(R.layout.fragment_data, container, false)

        return v
    }

    override fun onStart() {
        super.onStart()

       val userEmail = DataFragmentArgs.fromBundle(requireArguments()).user
              //DataFragmentArgs se crea solo al marcar que recibe parametros x el NavGraph

        val tvEmail = v.findViewById<TextView>(R.id.textView5); // ubico el textView

        tvEmail.setText(userEmail.email.toString())  // ojo aca con el toString!!!!

    }

}