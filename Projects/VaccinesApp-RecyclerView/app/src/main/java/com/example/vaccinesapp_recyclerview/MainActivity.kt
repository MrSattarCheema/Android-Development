package com.example.vaccinesapp_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Three steps for creating Recycler View
        //1- Adapter View: RecyclerVIew
        val recyelerView:RecyclerView=findViewById(R.id.recyclerView)
        recyelerView.layoutManager=LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        //LayoutManager is responsible for showing the recycler view in many forms like in grid or linear view
        //2- Data Source: list of VaccineModel class object
        val vaccineList:ArrayList<VacinneModel> = ArrayList()
        val v1:VacinneModel= VacinneModel("Covid-19",R.drawable.vaccine1)
        val v2=VacinneModel("Hepatitis B Vaccine",R.drawable.vaccine5)
        val v3=VacinneModel("Tatanus Vaccine",R.drawable.vaccine6)
        val v4=VacinneModel("Pneumococal Vaccine",R.drawable.vaccine7)
        val v5=VacinneModel("Rotavirus Vaccine",R.drawable.vaccine8)
        val v6=VacinneModel("Chickenpox Vaccine",R.drawable.vaccine9)
        vaccineList.add(v1)
        vaccineList.add(v2)
        vaccineList.add(v3)
        vaccineList.add(v4)
        vaccineList.add(v5)
        vaccineList.add(v6)
        //3- Adapter
        val adapter=VaccineAdapter(vaccineList)
        recyelerView.adapter=adapter
    }
}