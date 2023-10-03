package com.example.datachallenge.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.datachallenge.R
import com.example.datachallenge.model.Personaje

class PersonajeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val tvText = view.findViewById<TextView>(R.id.tvText)
    val tvMsg = view.findViewById<TextView>(R.id.tvMsg)
    val tvTime = view.findViewById<TextView>(R.id.tvTime)
    val tvPhoto = view.findViewById<ImageView>(R.id.tvPhoto)
    fun render ( personaje: Personaje){
        tvText.text = personaje.name;
        tvMsg.text = "${personaje.gender}  ${personaje.species}";
        tvTime.text=  "${personaje.id} Id"
        Glide.with(tvPhoto.context).load(personaje.image).circleCrop().into(tvPhoto)

    }
}
