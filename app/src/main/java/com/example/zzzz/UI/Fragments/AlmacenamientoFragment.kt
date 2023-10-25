package com.example.zzzz.UI.Fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zzzz.Model.Adapter.StudentAdapter
import com.example.zzzz.Model.Models.User
import com.example.zzzz.R
import com.example.zzzz.databinding.FragmentAlmacenamientoBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.reflect.Type


class AlmacenamientoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    lateinit var binding: FragmentAlmacenamientoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentAlmacenamientoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnObtener.setOnClickListener {
            ConsumoAlmacenamiento()
        }
        binding.Rview.layoutManager = LinearLayoutManager(binding.Rview.context)

    }

    private var openFileExplore: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { reuslts ->
            if (reuslts.resultCode == Activity.RESULT_OK) {
                val data = reuslts.data
                var uri = data?.data
                try {
                    val entradaDatos: InputStream? =
                        Fragment().activity?.contentResolver?.openInputStream(uri!!)
                    val leer = BufferedReader(InputStreamReader(entradaDatos))
                    val json = leer.readText()
                    val tipoLista: Type? = object : TypeToken<List<User>>() {}.type
                    var list: List<User> = Gson().fromJson(json, tipoLista)
                    binding.Rview.adapter = StudentAdapter(list.toMutableList())

                } catch (e: Exception) {
                    Log.e("Error", e.message.toString())
                }
            }
        }

    private fun ConsumoAlmacenamiento() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "*/*"
        openFileExplore.launch(intent)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AlmacenamientoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = AlmacenamientoFragment().apply {
            arguments = Bundle()
        }
    }
}