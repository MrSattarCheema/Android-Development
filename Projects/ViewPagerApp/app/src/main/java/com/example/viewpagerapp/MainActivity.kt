package com.example.viewpagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagerapp.adapter.FragmentAdapter

//View Pager in android display view or fragments in a swappable format
class MainActivity : AppCompatActivity() {
    lateinit var myAdapter:FragmentAdapter
    lateinit var viewPager:ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager=findViewById(R.id.viewPager)
        myAdapter=FragmentAdapter(this@MainActivity)
        viewPager.orientation=ViewPager2.ORIENTATION_HORIZONTAL
        viewPager.adapter=myAdapter
    }
}