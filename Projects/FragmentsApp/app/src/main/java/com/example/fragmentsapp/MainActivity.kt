package com.example.fragmentsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val f1Btn:Button=findViewById(R.id.f1Button)
        val f2Btn:Button=findViewById(R.id.f2Button)
        f1Btn.setOnClickListener(){
            val  fragment1:Fragment=Fragment1()
            val fTransaction:FragmentTransaction=supportFragmentManager.beginTransaction()
            //when we change a fragment this is called transaction
            fTransaction.replace(
                R.id.frame1,
                fragment1
            ).commit()
        }
        f2Btn.setOnClickListener(){
            val fragment2:Fragment=Fragment2()
            val fTransient:FragmentTransaction=supportFragmentManager.beginTransaction()
            fTransient.replace(
                R.id.frame2,
                fragment2
            ).commit()
        }
    }
}