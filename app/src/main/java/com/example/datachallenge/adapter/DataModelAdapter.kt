package com.example.datachallenge.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.datachallenge.DataModel
import com.example.datachallenge.R

class DataModelAdapter(private val dataModelList:List<DataModel>): RecyclerView.Adapter<DataModelHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataModelHolder {
      val layoutInflater = LayoutInflater.from(parent.context)
        return DataModelHolder(layoutInflater.inflate(R.layout.item_datamodel,parent, false))
    }

    override fun getItemCount(): Int = dataModelList.size // igual a return dataModelList.size

    override fun onBindViewHolder(holder: DataModelHolder, position: Int) {
       var item = dataModelList[position]
        holder.render(item)
    }
}