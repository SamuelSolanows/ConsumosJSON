package com.example.zzzz.UI.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zzzz.Model.Adapter.StudentAdapter
import com.example.zzzz.Model.Models.User
import com.example.zzzz.databinding.FragmentLocalBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.reflect.Type


class LocalFragment : Fragment() {
    lateinit var binding: FragmentLocalBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLocalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
           btnObtener.setOnClickListener {
               Rview.layoutManager = LinearLayoutManager(Rview.context)
               Rview.adapter = StudentAdapter(ConsumoLocal().toMutableList())
           }
        }

    }


    private fun ConsumoLocal(): List<User> {
        var res = resources
        val nombrearchivo = "res/raw/datos.json"
        val entrada = this.javaClass.classLoader.getResourceAsStream(nombrearchivo)
        try {
            val leer = BufferedReader(InputStreamReader(entrada))
            val json = leer.readText()
            val TipoLista: Type? = object : TypeToken<List<User>>() {}.type
            return Gson().fromJson(json, TipoLista)
        } catch (e: IOException) {
            Log.e("error", e.message.toString())
        }
        return emptyList()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LocalFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            LocalFragment().apply {
                arguments = Bundle()
            }
    }
}