package com.example.datachallenge.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.datachallenge.R
import com.example.datachallenge.listener.OnClickNavigate
import com.example.datachallenge.model.Personaje

class PersonajeAdapter(private val personajes: List<Personaje>) : RecyclerView.Adapter<PersonajeViewHolder>() {

    private var onPersonajeClickListener: OnClickNavigate? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_datamodel, parent, false)
        return PersonajeViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonajeViewHolder, position: Int) {
        val personaje = personajes[position]
        holder.render(personaje)
        holder.itemView.setOnClickListener {

            onPersonajeClickListener?.OnClickNavigate(personaje)
        }
    }

    override fun getItemCount(): Int {
        return personajes.size
    }

    fun setOnPersonajeClickListener (listener: OnClickNavigate) {
        onPersonajeClickListener = listener
    }

}
