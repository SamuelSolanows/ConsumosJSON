package com.example.zzzz.UI.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zzzz.Model.Adapter.StudentAdapter
import com.example.zzzz.Model.Api.Api
import com.example.zzzz.Model.Models.User
import com.example.zzzz.databinding.FragmentRetrofitBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RetrofitFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnObtener.setOnClickListener {
            LlamarApi()
        }

    }

    lateinit var binding: FragmentRetrofitBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRetrofitBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun LlamarApi() {
        Api.build.GetAllStudent().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                var a = response.body()
                binding.Rview.layoutManager = LinearLayoutManager(binding.Rview.context)
                binding.Rview.adapter = StudentAdapter(a!!.toMutableList())

            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e("Errpr", t.message.toString())
            }
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RetrofitFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            RetrofitFragment().apply {
                arguments = Bundle()
            }
    }
}