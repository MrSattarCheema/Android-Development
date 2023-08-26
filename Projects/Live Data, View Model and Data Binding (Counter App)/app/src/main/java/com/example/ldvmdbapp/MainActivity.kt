package com.example.ldvmdbapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ldvmdbapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        /*Instead of using setOnClickListner we use it directly in xml file by creating viewModelclass object there
         binding.btn.setOnClickListener() */
        //linking myViewModel object in xml with View Model class object
        binding.myViewModel=viewModel

        //using live data for update
        /* Instead of using observe we can directly use livedata object in xml file
        viewModel.counter.observe(
            this,
            Observer {
                binding.textView.text = it.toString()
            }
        ) */
        //for using livedata in xml file
        binding.lifecycleOwner = this@MainActivity
    }
}