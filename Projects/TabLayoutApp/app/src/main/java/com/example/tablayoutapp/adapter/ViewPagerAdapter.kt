package com.example.tablayoutapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tablayoutapp.fragments.BookFragment
import com.example.tablayoutapp.fragments.GamesFragment
import com.example.tablayoutapp.fragments.MoviesFragment


class ViewPagerAdapter(fragmentManger:FragmentManager,lifeCycle :Lifecycle): FragmentStateAdapter(fragmentManger,lifeCycle) {
    override fun getItemCount(): Int {
        return 3; //bcz we have 3 taps in out this app
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0->return BookFragment()
            1->return GamesFragment()
        }
        return MoviesFragment()
    }

}