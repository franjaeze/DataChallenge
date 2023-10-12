package com.example.datachallenge.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.datachallenge.R
import com.example.datachallenge.entity.Contact
import com.example.datachallenge.entity.Foto

class FotoViewHolder (private val view : View): RecyclerView.ViewHolder(view) {
    val tvText = view.findViewById<TextView>(R.id.tvFoto1)

    fun render ( foto: Foto){
        tvText.text = foto.nombre;


    }
}