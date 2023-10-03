package com.example.datachallenge.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.datachallenge.R
import com.example.datachallenge.adapter.PersonajeAdapter
import com.example.datachallenge.entity.Contact
import com.example.datachallenge.listener.OnClickNavigate
import com.example.datachallenge.model.PaginateResponse
import com.example.datachallenge.model.Personaje
import com.example.datachallenge.services.ActivityServiceApiBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DataFragment : Fragment(), OnClickNavigate {
    lateinit var v: View;
    var contacts: MutableList<Contact> = ArrayList()
    lateinit var pokemonTv:TextView
    // En tu clase
    private val personajeList = mutableListOf<Personaje>()
    private lateinit var adapter: PersonajeAdapter

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

        cargarPersonajes()
        return v
    }

    fun cargarPersonajes() {


        val service = ActivityServiceApiBuilder.create()

        service.getCharacters().enqueue(object : Callback<PaginateResponse<Personaje>> {
            override fun onResponse(
                call: Call<PaginateResponse<Personaje>>,
                response: Response<PaginateResponse<Personaje>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val responsePersonaje = response.body()

                    if (responsePersonaje != null) {
                        personajeList.addAll(responsePersonaje.results)
                    }

                    // Actualizar el RecyclerView
                    adapter.notifyDataSetChanged()


                } else {
                    Log.e("Respuesta no exitosa", " esta es la respuesta $response")
                }

                }

            override fun onFailure(call: Call<PaginateResponse<Personaje>>, t: Throwable) {
                Log.e("Example", t.stackTraceToString())
            }
        })
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
        contacts.add(Contact("Alex","tell me something",2, "https://loremflickr.com/320/240?random=11",124354554, conversation))
        contacts.add(Contact("Marina","Hey estoy abajo!",15, "https://loremflickr.com/320/240?random=2",43254114, conversation))
        contacts.add(Contact("Pietro","buenismo, hasta luego",27, "https://loremflickr.com/320/240?ra   ndom=31",49824354, conversation))
        contacts.add(Contact("Nova","no, no creo",32, "https://loremflickr.com/320/240?random=4",116573554, conversation))
        contacts.add(Contact("Amanda","hasta luego, buen finde",60, "https://loremflickr.com/320/240?random=5",24201884, conversation))
        contacts.add(Contact("Sergi","y donde se supone que voy a encontrarlo?",2, "https://loremflickr.com/320/240?random=6",22431845, conversation))
        contacts.add(Contact("Dario","nos falta 1",2, "https://loremflickr.com/320/240?random=7",23121554, conversation))
        contacts.add(Contact("Samantha","de Finibus Bonorum et Malorum",2, "https://loremflickr.com/320/240?random=8",5216254, conversation))
        contacts.add(Contact("Flor","to help keep the site on the Internet",2, "https://loremflickr.com/320/240?random=9",11365755, conversation))
        contacts.add(Contact("Giulia","hasta luego, buen finde",2, "https://loremflickr.com/320/240?random=10",545144388, conversation))

        val userLogin = DataFragmentArgs.fromBundle(requireArguments()).user
              //DataFragmentArgs se crea solo al marcar que recibe parametros x el NavGraph

        val tvEmail = v.findViewById<TextView>(R.id.textView5); // ubico el textView

        tvEmail.setText(userLogin.name.toString())  // ojo aca con el toString!!!!



        initRecycleView()


        val btnUser = v.findViewById<Button>(R.id.btnUser)

        btnUser.setOnClickListener{
            val action = DataFragmentDirections.actionDataFragmentToFragmentUser(userLogin)
            v.findNavController().navigate(action)
        }
    }

    private fun initRecycleView(){
        val recycleView = v.findViewById<RecyclerView>(R.id.recycleView)
        recycleView.layoutManager = LinearLayoutManager(requireContext())
       // recycleView.adapter = DataModelAdapter(DataModelProvider.dataModelList)
//        val adapter = ContactAdapter(contacts)

//        recycleView.adapter = adapter;
        adapter = PersonajeAdapter(personajeList)
            adapter.setOnPersonajeClickListener(this)
        recycleView.adapter = adapter

    }


    override fun OnClickNavigate(personaje: Personaje) {
         val action = DataFragmentDirections.actionDataFragmentToContactView(personaje)
        Log.e("click","estoy clickeando aqui!!!")
        this.findNavController().navigate(action)
    }





}