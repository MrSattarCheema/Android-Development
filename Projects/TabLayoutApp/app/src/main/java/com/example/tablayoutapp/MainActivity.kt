package com.example.tablayoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.tablayoutapp.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    val tabsArray= arrayOf("Books","Games","Movies")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager:ViewPager2=findViewById(R.id.viewPager)
        val tabLayout:TabLayout=findViewById(R.id.tabLayout)
        val adapter=ViewPagerAdapter(
            supportFragmentManager,
            lifecycle
        )
        viewPager.adapter=adapter
        //Connecting ViewPager with TabLayout
        TabLayoutMediator(tabLayout,viewPager){
            tab, position -> tab.text= tabsArray[position]
        }.attach()
        //is responsible for connecting the tab Layout with array tabsArray
    }
}