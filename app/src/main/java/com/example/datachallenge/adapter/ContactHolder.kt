package com.example.datachallenge.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.datachallenge.R
import com.example.datachallenge.entity.Contact

class ContactHolder (private val view : View): RecyclerView.ViewHolder(view) {
    val tvText = view.findViewById<TextView>(R.id.tvText)
    val tvMsg = view.findViewById<TextView>(R.id.tvMsg)
    val tvTime = view.findViewById<TextView>(R.id.tvTime)
    val tvPhoto = view.findViewById<ImageView>(R.id.tvPhoto)
    fun render ( contact: Contact){
        tvText.text = contact.name;
        tvMsg.text = contact.msj;
        tvTime.text= contact.time.toString() + " Min"
        Glide.with(tvPhoto.context).load(contact.urlImage).circleCrop().into(tvPhoto)

    }
}