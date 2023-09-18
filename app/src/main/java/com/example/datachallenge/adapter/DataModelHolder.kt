package com.example.datachallenge.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.datachallenge.DataModel
import com.example.datachallenge.R

class DataModelHolder(val view: View):RecyclerView.ViewHolder(view) {
    val tvMsgList = view.findViewById<TextView>(R.id.tvMsgList)
    fun render ( dataModel: String){
        tvMsgList.text = dataModel;




    }
}