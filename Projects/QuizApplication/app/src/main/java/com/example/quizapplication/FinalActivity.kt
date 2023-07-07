package com.example.quizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
        val tvName:TextView=findViewById(R.id.name)
        val tvScore:TextView=findViewById(R.id.score)
        val btnFinish: Button =findViewById(R.id.finishButton)
        tvName.text=intent.getStringExtra(Constant.USER_NAME)
        tvScore.text="You scor is ${intent.getIntExtra(Constant.CORRECT_ANSWER,0)} out of ${intent.getIntExtra(Constant.TOTAL_QUESTIONS,0)}"
        btnFinish.setOnClickListener(){
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}