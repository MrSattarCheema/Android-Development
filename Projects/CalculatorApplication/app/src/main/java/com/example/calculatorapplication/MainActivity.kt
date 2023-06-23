package com.example.calculatorapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    private var textViewInput: TextView?=null
    var isLastNumaric:Boolean=false
    var isLastDost:Boolean=false
    var isDotOccured:Boolean=false
    var isEqualPressed:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewInput=findViewById(R.id.screen)
    }
    fun onDigit(view: View){
        if(isEqualPressed){
           onClr(view)
            isEqualPressed=false
        }
        textViewInput?.append((view as Button).text)
        isLastNumaric=true
        isLastDost=false
    }
    fun onClr(view: View){
        textViewInput?.text=""
        isLastNumaric=false
        isLastDost=false
        isDotOccured=false
        isEqualPressed=false
    }

    fun onDecimal(view:View){
        if(isEqualPressed){
            onClr(view)
        }
        if(isLastNumaric && !isLastDost && !isDotOccured) {
            textViewInput?.append(".")
            isLastDost = true
            isLastNumaric = false
            isDotOccured=true
        }
        else{
            Toast.makeText(this,
            "Only one Decimal is allowed",
            Toast.LENGTH_LONG).show()
        }
    }
    fun onOperator(view:View){
        if(isEqualPressed){
            isEqualPressed=false
        }
        textViewInput?.text?.let{
            if(isLastNumaric && !isOepratorAdded(it.toString())){
                textViewInput?.append((view as Button).text)
                isLastNumaric=false
                isLastDost=false
                isDotOccured=false
                }
            else{
                Toast.makeText(this,
                    "Illegal Operation call",
                    Toast.LENGTH_LONG).show()
            }
        }
    }
    fun onEqual(view:View){
        isEqualPressed=true
        isDotOccured=false
        if(isLastNumaric) {
            var screenValue = textViewInput?.text.toString()
            try {
                var prefix=""
                if(screenValue.startsWith("-")){
                    prefix="-"
                    screenValue=screenValue.substring(1)
                }
                if(screenValue.contains("-")){
                    var splitValue = screenValue.split("-")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if(prefix.isNotEmpty()){
                        one=prefix+one
                    }
                    var rslt=(one.toDouble() - two.toDouble()).toString()
                    textViewInput?.text = removeZero(rslt)
                }
                else if(screenValue.contains("+")){
                    var splitValue = screenValue.split("+")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if(prefix.isNotEmpty()){
                        one=prefix+one
                    }
                    textViewInput?.text = removeZero((one.toDouble() + two.toDouble()).toString())
                }
                else if(screenValue.contains("/")){
                    var splitValue = screenValue.split("/")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if(prefix.isNotEmpty()){
                        one=prefix+one
                    }
                    textViewInput?.text = removeZero((one.toDouble() / two.toDouble()).toString())
                }
                else if(screenValue.contains("*")){
                    var splitValue = screenValue.split("*")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if(prefix.isNotEmpty()){
                        one=prefix+one
                    }
                    textViewInput?.text = removeZero((one.toDouble() * two.toDouble()).toString())
                }
            }catch (e: ArithmeticException){
                e.printStackTrace()
            }
        }
    }
    private fun removeZero(result:String):String{
        var value=result
        if(result.contains(".0")){
            value=value.substring(0,result.length-2)
        }
        return value;
    }
    private  fun isOepratorAdded(value: String):Boolean{
        return if(value.startsWith("-")){
            false
        }
        else{
            value.contains("+") || value.contains("-") || value.contains("*") || value.contains("/")
        }

    }
}
