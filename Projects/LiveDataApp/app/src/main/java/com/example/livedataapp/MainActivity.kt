package com.example.livedataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedataapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel
    lateinit var viewModelFactory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModelFactory= MainActivityViewModelFactory(100)
        //Connecting view model with ViewModel factory
        viewModel=ViewModelProvider(this,viewModelFactory).get(MainActivityViewModel::class.java)

        //Observing for any data change in LiveData
        viewModel.totalSum.observe(
            this,
            Observer {
                binding.txt.text=it.toString()
            }
        )
        binding.btn.setOnClickListener(){
            viewModel.sumUp(binding.EditText.text.toString().toInt())
        }

    }
}