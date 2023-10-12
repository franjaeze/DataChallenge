package com.example.datachallenge.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.datachallenge.R
import com.example.datachallenge.adapter.ContactAdapter
import com.example.datachallenge.adapter.FotoAdapter
import com.example.datachallenge.adapter.PersonajeAdapter
import com.example.datachallenge.databinding.FragmentHomeBinding
import com.example.datachallenge.entity.Contact
import com.example.datachallenge.entity.Foto

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    var fotos: MutableList<Foto> = ArrayList()
    private lateinit var adapter: FotoAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }


    override fun onStart() {
        super.onStart()
        fotos.add(Foto("Fotos"))
        fotos.add(Foto("Fotos"))
        fotos.add(Foto("Fotos"))
        fotos.add(Foto("Fotos"))
        fotos.add(Foto("Fotos"))
        fotos.add(Foto("Fotos"))
        fotos.add(Foto("Fotos"))
        fotos.add(Foto("Fotos"))

        initRecycleView()
    }



        override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecycleView(){
        val recycleView = binding.rvFotos
        recycleView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        // recycleView.adapter = DataModelAdapter(DataModelProvider.dataModelList)
//        val adapter = ContactAdapter(contacts)

//        recycleView.adapter = adapter;
        adapter = FotoAdapter(fotos)
        recycleView.adapter = adapter

    }

}