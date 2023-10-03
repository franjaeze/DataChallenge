package com.example.datachallenge.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.datachallenge.R
import com.example.datachallenge.entity.Contact
import com.example.datachallenge.listener.OnClickNavigate

class ContactAdapter (private val contacts:List<Contact>): RecyclerView.Adapter<ContactHolder>()  {

    private var onContactClickListener: OnClickNavigate? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ContactHolder(layoutInflater.inflate(R.layout.item_datamodel,parent, false))
    }

    override fun getItemCount(): Int = contacts.size

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        var item = contacts[position]
        holder.render(item)

//        holder.itemView.setOnClickListener {
//            onContactClickListener?.OnClickNavigate(item)
//        }
    }
    fun setOnContactClickListener(listener: OnClickNavigate) {
        onContactClickListener = listener
    }

}