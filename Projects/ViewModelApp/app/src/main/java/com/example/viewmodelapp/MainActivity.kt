package com.example.viewmodelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
//When we rotate an app the var data of activity lost, there for we use View Model
//But we cannot pass parameters to ViewModelClass therefore we create another class called ViewModelFactory
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel:MainActivityViewModel
    private lateinit var viewModelFactory:MainActivityViewModelFactory //in case we use ViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //If we want to pass parameter then use ViewModelFactory otherwise only viewModel is enough
        viewModelFactory= MainActivityViewModelFactory(100)
        //connecting viewModelclass and this main class and factory class
        viewModel=ViewModelProvider(this,viewModelFactory).get(MainActivityViewModel::class.java)

        //In case we only use ViewModel class
        //connecting viewModelclass and this main class
//        viewModel=ViewModelProvider(this).get(MainActivityViewModel::class.java)
        val txtView:TextView=findViewById(R.id.txtView)
        txtView.text=viewModel.getCurrentCount().toString()
        val btn:Button=findViewById(R.id.btn)
        btn.setOnClickListener(){
            txtView.setText("${viewModel.getUpdatedCount()}")
        }
    }
}