package com.example.guessluckynumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvName:EditText=findViewById(R.id.editText)
        val number:Int= Random.nextInt(100)
        val btn:Button=findViewById(R.id.button)
        btn.setOnClickListener(){
            val intent=Intent(this,FinalActivity::class.java)
            intent.putExtra("Name",tvName.text.toString())
            intent.putExtra("number",number)
            startActivity(intent)
        }
    }
}