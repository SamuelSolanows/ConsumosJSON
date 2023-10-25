package com.example.zzzz.Model.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zzzz.Model.Models.User
import com.example.zzzz.databinding.ItemStudentBinding

class StudentAdapter(var list: MutableList<User>) :
    RecyclerView.Adapter<StudentAdapter.Holder>() {
    inner class Holder(var binding: ItemStudentBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemStudentBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        var user = list[position]
        var binding = holder.binding
        user.apply {
            binding.apply {
                txtName.text = FullName
                txtUsuario.text = Username
                txtContrasena.text = Password
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}