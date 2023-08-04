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
        val view:View? //contains the item which getView generates
        val viewholder:ViewHolder //viewHolder provide meta data about about its place
        //let viewHolder is a class use to initialize widgets of custom layouts
        if(convertView==null){ //convertView is for recycling, it is used for convert the view for converting the view from item that
            //is scrolled out the screen into the newly newly created ones that jumps into the screen. Example scrolling down and seeing new list items
            val inflater=activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            //Layout inflater is used to get view object which we define in XML layout, it is dynamic usage of creating UI elements
            view=inflater.inflate(R.layout.list_item,null) //inflate means display and null means return null if it is not present
            viewholder=ViewHolder(view) //here we are initializing viewHolder by calling viewHolder class
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