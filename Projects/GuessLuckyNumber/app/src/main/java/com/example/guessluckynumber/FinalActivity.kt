package com.example.guessluckynumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class FinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
        val tvLuckyNumber:TextView=findViewById(R.id.textView3)
        tvLuckyNumber.text=intent.getIntExtra("number",0).toString()
        Toast.makeText(this,"Hello: "+receiveName(),Toast.LENGTH_LONG).show()
        val btn:Button=findViewById(R.id.button2)
        btn.setOnClickListener(){
            var i=Intent(Intent.ACTION_SEND)
            i.setType("Text/Plane")
            i.putExtra(Intent.EXTRA_SUBJECT,"${receiveName()} is lucky today")
            i.putExtra(Intent.EXTRA_TEXT,"His lucky number is $tvLuckyNumber")
            startActivity(i)
        }
    }
    private fun receiveName():String{
        val name: String =intent.getStringExtra("Name").toString()
//        val bundle:Bundle?=intent.extras
//        val name:String=bundle?.get("name").toString()
        return name
    }
}