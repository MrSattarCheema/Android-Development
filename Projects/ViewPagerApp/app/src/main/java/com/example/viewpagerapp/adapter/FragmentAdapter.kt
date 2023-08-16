package com.example.viewpagerapp.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpagerapp.MainActivity
import com.example.viewpagerapp.fragments.Fragment1
import com.example.viewpagerapp.fragments.Fragment2
import com.example.viewpagerapp.fragments.Fragment3

class FragmentAdapter(mainActivity: MainActivity): FragmentStateAdapter(mainActivity) {
    private val noOfFragment=3 //total fragments that we have
    override fun getItemCount(): Int {
        return this.noOfFragment
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0->return Fragment1()
            1->return Fragment2()
            2->return Fragment3()

        }
        return Fragment1() //act as home or default fragment
    }
}