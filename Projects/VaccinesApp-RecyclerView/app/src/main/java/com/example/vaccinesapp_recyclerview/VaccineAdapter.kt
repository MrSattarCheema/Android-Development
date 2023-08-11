package com.example.vaccinesapp_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class VaccineAdapter(val vaccineList:ArrayList<VacinneModel>):RecyclerView.Adapter<VaccineAdapter.MyViewHolder>() {
    //viewHolder provide meta data about about its place
    //let viewHolder is a class use to initialize widgets of custom layouts
inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    lateinit var vaccineImage:ImageView
    lateinit var vaccineName:TextView
    init {
        vaccineImage=itemView.findViewById(R.id.imageView)
        vaccineName=itemView.findViewById(R.id.textView)

        itemView.setOnClickListener() {
            Toast.makeText(
                itemView.context,
                "You selected: ${vaccineList[adapterPosition].text}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //this method is for creating the costume views
        val v=LayoutInflater.from(parent.context).inflate(R.layout.custom_recycler,parent,false)
        //LayoutInflater is a dynamic way of creating UI widgets, used to dynamically initiate xml objects
        //Layout inflater is used to get view object which we define in costume XML layout
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return vaccineList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //this method is for setting the data to corresponding UI widgets
        holder.vaccineName.setText(vaccineList[position].text)
        holder.vaccineImage.setImageResource(vaccineList[position].image)

    }
}