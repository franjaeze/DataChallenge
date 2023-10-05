package com.example.datachallenge.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.datachallenge.R
import com.example.datachallenge.adapter.DataModelAdapter
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
        val personaje = ContactViewArgs.fromBundle(requireArguments()).personaje
        //DataFragmentArgs se crea solo al marcar que recibe parametros x el NavGraph

        val tvName = v.findViewById<TextView>(R.id.tvName1); // ubico el textView
        val tvMsg = v.findViewById<TextView>(R.id.tvMsg1); // ubico el textView
        val contactPic = v.findViewById<ImageView>(R.id.contactPic); // ubico el textView
        val phone = v.findViewById<TextView>(R.id.phone)

        tvName.setText(personaje.name.toString())  // ojo aca con el toString!!!!
        tvMsg.setText("Created ${convertirFecha(personaje.created)}")  // ojo aca con el toString!!!!
        Glide.with(contactPic.context).load(personaje.image).circleCrop().into(contactPic)
        phone.setText("Id: " + personaje.id.toString())


        val recyclerView = v.findViewById<RecyclerView>(R.id.recycleView2)
        val messages = personaje.episode // Tu lista de mensajes

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = DataModelAdapter(messages)






    }

    fun convertirFecha(fechaString: String): String {
        val partes = fechaString.split("T")
        val fecha = partes[0]
        val tiempo = partes[1]

        val partesFecha = fecha.split("-")
        val dia = partesFecha[2]
        val mes = partesFecha[1]
        val anio = partesFecha[0]

        return "$dia-$mes-$anio"
    }
}