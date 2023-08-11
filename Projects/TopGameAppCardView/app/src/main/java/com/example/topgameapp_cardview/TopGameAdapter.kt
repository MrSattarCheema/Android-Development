package com.example.topgameapp_cardview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class TopGameAdapter(val gamesList:ArrayList<TopGameModel>):
RecyclerView.Adapter<TopGameAdapter.MyViewHolder>(){
    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        lateinit var gameName:TextView
        lateinit var gameImg:ImageView
        init {
            gameName=itemView.findViewById(R.id.gameTitle)
            gameImg=itemView.findViewById(R.id.image)
            itemView.setOnClickListener(){
                Toast.makeText(
                    itemView.context,
                    "You selected ${gamesList[adapterPosition].gameName}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.custome_card_item,parent,false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.gameName.setText(gamesList[position].gameName)
        holder.gameImg.setImageResource(gamesList[position].gameImg)
    }
}