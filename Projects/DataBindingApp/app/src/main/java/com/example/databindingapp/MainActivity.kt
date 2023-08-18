package com.example.databindingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databindingapp.databinding.ActivityMainBinding

/*we use data binding bcz findViewById() can cases app crash or app not responding
when their are many var of findViewById() bcz it initialize them at run time so if mobile have 80hz
refresh rate it's only have 8.8 milli seconds to initialize
--------------------------Using Data Binding-----------------
1- edit gradle module file
2- add layout tag to activity xml file
3- create object of layout xml file and remove setContentView methpd
 */
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.button.setOnClickListener(){
            binding.textView.setText("Hello ${binding.editTxt.text.toString()}")
        }
    }
}