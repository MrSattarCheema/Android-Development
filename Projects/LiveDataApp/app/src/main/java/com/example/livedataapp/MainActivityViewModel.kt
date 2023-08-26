package com.example.livedataapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(starting:Int) : ViewModel() {
    private var total= MutableLiveData<Int>()
    /* Live Data is data holder class that follows observer pattern. It holds primitives and
    collection types and notifies the observers when the data has changed. Mutable live data
    is a part of Live data. In liveData class the data can only be read but can't change
    but in mutable live data the data can be read and also editable */
    // to get the livedata, bcz above var is private
    val totalSum : LiveData<Int>
        get()=total
    init {
        total.value=starting
    }
    fun sumUp(input:Int){
        total.value=(total.value)?.plus(input)
    }
}