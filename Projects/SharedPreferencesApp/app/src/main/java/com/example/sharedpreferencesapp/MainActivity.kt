package com.example.sharedpreferencesapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var savedName:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val enteredName:EditText=findViewById(R.id.enteredName)
        savedName=findViewById(R.id.name)
        val btnSubmit:Button=findViewById(R.id.button)
        btnSubmit.setOnClickListener(){
            saveNameInSharedPref(enteredName.text.toString())
        }
        displayFromSharedPref()
    }
    private fun saveNameInSharedPref(enteredTxt: String){
        //Opening the shared Preferences, creating object of SharedPref
        val sharedPreferences:SharedPreferences=getSharedPreferences(
            "UserName", // any name of the sharedPref that we are going to create
            MODE_PRIVATE //to keep data not shared only private or encrypted
        )
        // writing data to shared pref
        val editor:SharedPreferences.Editor=sharedPreferences.edit()
        editor.putString("name",enteredTxt)// Storing data in key value pair
        editor.commit()
    }
    //Reading data from sharedPref
    private fun displayFromSharedPref(){
        //Opening the shared Preferences, creating object of SharedPref
        val sharedPreferences:SharedPreferences=getSharedPreferences(
            "UserName", //opening the same sharedPref that we have prev created ny same Name
            MODE_PRIVATE
        )
        val s1:String?=sharedPreferences.getString(
            "name", //the key name
            " " //default value
        )
        savedName.setText(s1)
    }
}