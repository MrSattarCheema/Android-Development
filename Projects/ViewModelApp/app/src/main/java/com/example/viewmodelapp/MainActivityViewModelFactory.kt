package com.example.viewmodelapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivityViewModelFactory(private val startingNum:Int):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T { //T is any type
        if(modelClass.isAssignableFrom(MainActivityViewModel::class.java))
            return MainActivityViewModel(startingNum) as T
        throw IllegalArgumentException("Unknown view model class")
    }
}