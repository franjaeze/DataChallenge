package com.example.datachallenge.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.datachallenge.R
import com.example.datachallenge.entity.Foto

class FotoAdapter(private val fotos :List<Foto>): RecyclerView.Adapter<FotoViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FotoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FotoViewHolder(layoutInflater.inflate(R.layout.item_foto,parent, false))
    }

    override fun getItemCount(): Int = fotos.size

    override fun onBindViewHolder(holder: FotoViewHolder, position: Int) {
        var item = fotos[position]
        holder.render(item)


    }


}
