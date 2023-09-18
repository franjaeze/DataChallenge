package com.example.datachallenge.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.datachallenge.R
import com.example.datachallenge.entity.Contact


class ContactView : Fragment() {
 lateinit var v: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_contact_view, container, false)
        return v
    }

    override fun onStart() {
        super.onStart()
        val contact = ContactViewArgs.fromBundle(requireArguments()).contact
        //DataFragmentArgs se crea solo al marcar que recibe parametros x el NavGraph

        val tvName = v.findViewById<TextView>(R.id.tvName1); // ubico el textView
        val tvMsg = v.findViewById<TextView>(R.id.tvMsg1); // ubico el textView
        val contactPic = v.findViewById<ImageView>(R.id.contactPic); // ubico el textView

        tvName.setText(contact.name.toString())  // ojo aca con el toString!!!!
        tvMsg.setText(contact.msj.toString())  // ojo aca con el toString!!!!
        Glide.with(contactPic.context).load(contact.urlImage).circleCrop().into(contactPic)
    }
}