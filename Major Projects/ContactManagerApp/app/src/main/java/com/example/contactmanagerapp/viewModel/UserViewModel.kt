package com.example.contactmanagerapp.viewModel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactmanagerapp.room.User
import com.example.contactmanagerapp.room.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel(), Observable {
    val users = repository.users
    private var isUpdateOrDelete = false
    private lateinit var userToUpdateOrDelete: User
    @Bindable //bindable annotation should be applied to any getter accessor method fo any observable class
    val inputName = MutableLiveData<String?>()
    @Bindable
    val inputNumber = MutableLiveData<String?>()
    @Bindable
    val saveOrUpdateBtnTxt = MutableLiveData<String>()
    @Bindable
    val deleteOrClearBtnTxt = MutableLiveData<String>()
    init {
        saveOrUpdateBtnTxt.value = "Save"
        deleteOrClearBtnTxt.value = "Clear"
    }
    fun saveOrUpdate(){
        if(isUpdateOrDelete){
            //Make Update
            userToUpdateOrDelete.name = inputName.value!!
            userToUpdateOrDelete.number = inputNumber.value!!
            update(userToUpdateOrDelete)
        }
        else{
            //Make new Save
            val name =  inputName.value!! //called not null assertion operator, it will not allow holding the null value
            val number = inputNumber.value!!
            insert(User(0,name,number))

            inputNumber.value = null
            inputName.value = null
        }
    }
    fun clearOrDelete(){
        if(isUpdateOrDelete){
            delete(userToUpdateOrDelete)
        }
        else
            clearAll()
    }
    fun insert(user: User) = viewModelScope.launch {
        repository.insert(user)
    }
    fun clearAll() = viewModelScope.launch {
        repository.deleteAll()
    }
    fun update(user: User) = viewModelScope.launch {
        repository.update(user)
        //resetting the btns
        inputName.value = null
        inputNumber.value = null
        isUpdateOrDelete = false
        saveOrUpdateBtnTxt.value = "Save"
        deleteOrClearBtnTxt.value = "Clear"
    }
    fun delete(user:User) = viewModelScope.launch {
        repository.delete(user)
        // Resetting the Buttons and Fields
        inputName.value = null
        inputNumber.value = null
        isUpdateOrDelete = false
        saveOrUpdateBtnTxt.value  = "Save"
        deleteOrClearBtnTxt.value = "Clear"
    }
    // bcz we extends Observable so we must have to define these functions
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    fun initUpdateAndDelete(user: User) {
        inputName.value = user.name
        inputNumber.value = user.number
        isUpdateOrDelete = true
        userToUpdateOrDelete = user
        saveOrUpdateBtnTxt.value = "Update"
        deleteOrClearBtnTxt.value = "Delete"
    }
}