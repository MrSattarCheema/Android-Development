package com.example.worldcupapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listView:ListView=findViewById(R.id.listview)
        var adapter=Adapter(
            this,
            generateData()
        )
        listView.adapter =adapter
        adapter.notifyDataSetChanged()
    }
    fun generateData():ArrayList<CountryModel>{
        var result=ArrayList<CountryModel>()
        var country1:CountryModel= CountryModel(
            "Brazil",
            "5",
            R.drawable.brazil
        )
        var country2:CountryModel=CountryModel(
            "Germany",
            "4",
            R.drawable.germany
        )
        var country3:CountryModel=CountryModel(
            "France",
            "2",
            R.drawable.france
        )
        var country4:CountryModel=CountryModel(
            "Spain",
            "1",
            R.drawable.spain
        )
        var country5:CountryModel=CountryModel(
            "England",
            "1",
            R.drawable.unitedkingdom
        )
        var country6:CountryModel=CountryModel(
            "USA",
            "0",
            R.drawable.unitedstates
        )
        var country7:CountryModel=CountryModel(
            "Saudi Arabia",
            "0",
            R.drawable.saudiarabia
        )
        result.add(country1)
        result.add(country2)
        result.add(country3)
        result.add(country4)
        result.add(country5)
        result.add(country6)
        result.add(country7)
        return result
    }
}