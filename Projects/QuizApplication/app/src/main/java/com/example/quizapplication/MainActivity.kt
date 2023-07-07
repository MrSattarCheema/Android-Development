package com.example.quizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart: Button =findViewById(R.id.btnStart)
        val inputName: EditText =findViewById(R.id.inputName)
        btnStart.setOnClickListener(){
            if(inputName.text.isNotEmpty()){
                val intent= Intent(this,quizQestionActivity::class.java)
                intent.putExtra(Constant.USER_NAME,inputName.text.toString())
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this,
                    "Please Enter Name",Toast.LENGTH_LONG).show()
            }
        }
    }
}