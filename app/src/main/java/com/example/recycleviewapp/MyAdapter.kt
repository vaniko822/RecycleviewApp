package com.example.recycleviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val studentList: ArrayList<Student>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent,
            false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = studentList[position]

        holder.firstname.text = currentitem.firstname
        holder.lastname.text = currentitem.lastname
        holder.email.text = currentitem.email
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val firstname : TextView = itemView.findViewById(R.id.firstName)
        val lastname : TextView = itemView.findViewById(R.id.lastName)
        val email : TextView = itemView.findViewById(R.id.email)
    }

}