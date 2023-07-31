package com.example.worldcupapp

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.getSystemService

class Adapter(private var activity: Activity,private var items:ArrayList<CountryModel>):BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(p0: Int): CountryModel {
        return items[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
        val view:View?
        val viewholder:ViewHolder
        if(convertView==null){
            val inflater=activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view=inflater.inflate(R.layout.list_item,null)
            viewholder=ViewHolder(view)
            view?.tag=viewholder
        }
        else{
            view =convertView
            viewholder=view.tag as ViewHolder
        }
        var contries=items[position]
        viewholder.txtView?.text=contries.name
        viewholder.txtCupWin?.text=contries.wins
        viewholder.flagImg?.setImageResource(contries.image)
        view?.setOnClickListener(){
            Toast.makeText(activity,
                "You Choose: ${contries.name}",
                Toast.LENGTH_SHORT
            ).show()
        }
        return view as View
    }
    private class ViewHolder(row:View?){
        var txtView:TextView?=null
        var txtCupWin:TextView?=null
        var flagImg:ImageView?=null

        init {
            this.txtView=row?.findViewById(R.id.countryName)
            this.txtCupWin=row?.findViewById(R.id.wins)
            this.flagImg=row?.findViewById(R.id.countryImage)
        }
    }



}