package com.example.ldvmdbapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private var counter = MutableLiveData<Int>()
    val countData : LiveData<Int>
        get() = counter
    init {
        counter.value=0
    }
    fun updateCounter(){
        counter.value=(counter.value)?.plus(1)
    }
}