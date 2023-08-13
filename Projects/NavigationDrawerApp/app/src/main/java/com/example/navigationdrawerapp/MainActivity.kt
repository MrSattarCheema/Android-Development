package com.example.navigationdrawerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var toggle:ActionBarDrawerToggle
    private lateinit var drawerLayout:DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout=findViewById(R.id.drawerLayout)
        toggle=ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open,
            R.string.close
        )
        //to combine toggle and drawerlayout that we have created
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState() //for closing or opening toggle
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //home fragment will be displayed first
        //functionality for the nav drawer items
        val navView: NavigationView=findViewById(R.id.navigation)
        navView.setNavigationItemSelectedListener {
            it.isChecked= true
            when(it.itemId){
                R.id.home->{
                    replaceFragment(HomeFragment(),it.title.toString())
                }
                R.id.setting->{
                    replaceFragment(SettingFragment(),it.title.toString())
                }
                R.id.message->{
                    replaceFragment(MsgFragment(),it.title.toString())
                }
                R.id.login->{
                    replaceFragment(LoginFragment(),it.title.toString())
                }
            }
            true
        }
    }
    private fun replaceFragment(fragment:Fragment,title:String){
        val fragmentManager=supportFragmentManager
        val fragTransaction=fragmentManager.beginTransaction()
        fragTransaction.replace(R.id.frame,fragment)
        fragTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }
}