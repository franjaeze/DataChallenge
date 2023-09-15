package com.example.datachallenge.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.datachallenge.DataModel
import com.example.datachallenge.R

class DataModelHolder(val view: View):RecyclerView.ViewHolder(view) {
    val tvText = view.findViewById<TextView>(R.id.tvText)
    val tvPhoto = view.findViewById<ImageView>(R.id.tvPhoto)
    fun render ( dataModel: DataModel){
        tvText.text = dataModel.dataText;


    }
}