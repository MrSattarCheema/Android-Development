package com.example.contactmanagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactmanagerapp.viewModel.UserViewModel
import com.example.contactmanagerapp.databinding.ActivityMainBinding
import com.example.contactmanagerapp.room.User
import com.example.contactmanagerapp.room.UserDatabase
import com.example.contactmanagerapp.room.UserRepository
import com.example.contactmanagerapp.viewModel.UserViewModelFactory
import com.example.contactmanagerapp.viewUI.MyRecyclerVIewAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var userViewModel : UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //Room Database
        val dao = UserDatabase.getInstance(application).userDAO
        val repository = UserRepository(dao)
        val factory = UserViewModelFactory(repository)
        //connecting things together
        userViewModel = ViewModelProvider(this,factory).get(UserViewModel::class.java)
        binding.userViewModel = userViewModel
        binding.lifecycleOwner = this

        //initiate recycler View
        initRecyclerVIew()
    }
    private fun initRecyclerVIew(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        displayUserList()
    }

    private fun displayUserList() {
        userViewModel.users.observe(
            this,
            Observer {
                binding.recyclerView.adapter =  MyRecyclerVIewAdapter(
                    it, {
                        selectedItem: User -> listItemClicked(selectedItem)
                    }
                )
            }
        )
    }

    private fun listItemClicked(selectedItem: User) {
        Toast.makeText(
            this,
            "Selected Item is ${selectedItem.name}",
            Toast.LENGTH_LONG).show()
        userViewModel.initUpdateAndDelete(selectedItem)
    }
}