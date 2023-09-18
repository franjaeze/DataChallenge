package com.example.datachallenge.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.datachallenge.DataModelProvider
import com.example.datachallenge.R
import com.example.datachallenge.adapter.ContactAdapter
import com.example.datachallenge.adapter.DataModelAdapter
import com.example.datachallenge.entity.Contact
import com.example.datachallenge.listener.OnClickNavigate


class DataFragment : Fragment(), OnClickNavigate {
 lateinit var v : View;
    var contacts : MutableList<Contact> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
     v = inflater.inflate(R.layout.fragment_data, container, false)
        return v
    }

    override fun onStart() {
        val conversation:MutableList<String> = mutableListOf()

        for (i in 1..10) {
            conversation.add("Miauuuuu....")
            conversation.add("Miiiiiiiiiiiiau")
            conversation.add("Mmmmm aaaaaauuuu")
            conversation.add("Miau miau miaaaau miau")
        }


        super.onStart()
        contacts.add(Contact("Alex","tell me something",2, "https://loremflickr.com/320/240?random=1",124354554, conversation))
        contacts.add(Contact("Marina","Hey estoy abajo!",15, "https://loremflickr.com/320/240?random=2",43254114, conversation))
        contacts.add(Contact("Pietro","buenismo, hasta luego",27, "https://loremflickr.com/320/240?random=3",49824354, conversation))
        contacts.add(Contact("Nova","no, no creo",32, "https://loremflickr.com/320/240?random=4",116573554, conversation))
        contacts.add(Contact("Amanda","hasta luego, buen finde",60, "https://loremflickr.com/320/240?random=5",24201884, conversation))
        contacts.add(Contact("Sergi","y donde se supone que voy a encontrarlo?",2, "https://loremflickr.com/320/240?random=6",22431845, conversation))
        contacts.add(Contact("Dario","nos falta 1",2, "https://loremflickr.com/320/240?random=7",23121554, conversation))
        contacts.add(Contact("Samantha","de Finibus Bonorum et Malorum",2, "https://loremflickr.com/320/240?random=8",5216254, conversation))
        contacts.add(Contact("Flor","to help keep the site on the Internet, please consider donating a small",2, "https://loremflickr.com/320/240?random=9",11365755, conversation))
        contacts.add(Contact("Giulia","hasta luego, buen finde",2, "https://loremflickr.com/320/240?random=10",545144388, conversation))

        val userEmail = DataFragmentArgs.fromBundle(requireArguments()).user
              //DataFragmentArgs se crea solo al marcar que recibe parametros x el NavGraph

        val tvEmail = v.findViewById<TextView>(R.id.textView5); // ubico el textView

        tvEmail.setText(userEmail.email.toString())  // ojo aca con el toString!!!!
        initRecycleView()
    }

    private fun initRecycleView(){
        val recycleView = v.findViewById<RecyclerView>(R.id.recycleView)
        recycleView.layoutManager = LinearLayoutManager(requireContext())
       // recycleView.adapter = DataModelAdapter(DataModelProvider.dataModelList)
        val adapter = ContactAdapter(contacts)
        adapter.setOnContactClickListener(this)
        recycleView.adapter = adapter;
    }


    override fun OnClickNavigate(contact: Contact) {
         val action = DataFragmentDirections.actionDataFragmentToContactView(contact)
        this.findNavController().navigate(action)
    }



}