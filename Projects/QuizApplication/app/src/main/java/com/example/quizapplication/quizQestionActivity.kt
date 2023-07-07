package com.example.quizapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Contacts
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class quizQestionActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPostion:Int=1
    private var mQuestionList:ArrayList<Question>?=null
    private var mCurrentSelectedOption:Int=0
    private var mCorrectAnswers:Int=0

    private var userName:String?=null
    private var progressBar:ProgressBar?=null
    private var tvProgress:TextView?=null
    private var tvQuestion:TextView?=null
    private var ivImage:ImageView?=null
    private var tvOptionOne:TextView?=null
    private var tvOptionTwo:TextView?=null
    private var tvOptionThree:TextView?=null
    private var tvOptionFour:TextView?=null
    private var btnSubmitQuestions:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_qestion)
        progressBar=findViewById(R.id.progressBar)
        tvProgress=findViewById(R.id.textProgress)
        tvQuestion=findViewById(R.id.tvQuestion)
        ivImage=findViewById(R.id.iv_image)
        tvOptionOne=findViewById(R.id.optionOne)
        tvOptionTwo=findViewById(R.id.optionTwo)
        tvOptionThree=findViewById(R.id.optionThree)
        tvOptionFour=findViewById(R.id.optionFour)
        btnSubmitQuestions=findViewById(R.id.AnsSubmit)
        userName=intent.getStringExtra(Constant.USER_NAME)

        mQuestionList = Constant.getQuestion()
        setQuestion()
        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmitQuestions?.setOnClickListener(this)
    }

    private fun setQuestion() {
        defaultOptionView()
        val question: Question = mQuestionList!![mCurrentPostion - 1]
        progressBar?.progress = mCurrentPostion
        tvProgress?.text = "$mCurrentPostion/${progressBar?.max}"
        tvQuestion?.text = question.question
        ivImage?.setImageResource(question.image)
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour
        if(mCurrentPostion== mQuestionList!!.size){
            btnSubmitQuestions?.text="Finish"
        }
        else{
            btnSubmitQuestions?.text="SUBMIT"
        }
    }
    private fun defaultOptionView(){
        val options=ArrayList<TextView>()
        tvOptionOne?.let{
            options.add(0,it)
        }
        tvOptionTwo?.let {
            options.add(1,it)
        }
        tvOptionThree?.let{
            options.add(2,it)
        }
        tvOptionFour?.let {
            options.add(3,it)
        }
        for(i in options){
            i.setTextColor(Color.parseColor("#7A8089"))
            i.typeface= Typeface.DEFAULT
            i.background=ContextCompat.getDrawable(
                this@quizQestionActivity,R.drawable.defualt_option_bg
            )
        }
    }
    private fun selectedOptionView(textView:TextView,selectedOptionNum:Int){
        defaultOptionView()
        mCurrentSelectedOption=selectedOptionNum
        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface,Typeface.BOLD)
        textView.background=ContextCompat.getDrawable(
            this@quizQestionActivity,R.drawable.selected_option
        )
    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.optionOne -> {
                tvOptionOne?.let{
                    selectedOptionView(it,1)
                }
            }
            R.id.optionTwo -> {
                tvOptionTwo?.let{
                    selectedOptionView(it,2)
                }
            }
            R.id.optionThree -> {
                tvOptionThree?.let{
                    selectedOptionView(it,1)
                }
            }
            R.id.optionFour -> {
                tvOptionFour?.let{
                    selectedOptionView(it,1)
                }
            }
            R.id.AnsSubmit->{
                if(mCurrentSelectedOption==0){
                    mCurrentPostion++
                   when{
                       mCurrentPostion<=mQuestionList!!.size->{
                           setQuestion()
                       }
                       else ->{
                           val intent = Intent(
                               this,
                               FinalActivity::class.java
                           )
                           intent.putExtra(Constant.USER_NAME,userName)
                           intent.putExtra(Constant.CORRECT_ANSWER,mCorrectAnswers)
                           intent.putExtra(Constant.TOTAL_QUESTIONS,mQuestionList?.size)
                           startActivity(intent)
                           finish()
                       }
                   }
                }
                else{
                    val question=mQuestionList?.get(mCurrentPostion-1)
                    if(question!!.correctAns!=mCurrentSelectedOption){
                        answerView(mCurrentSelectedOption,R.drawable.wrong_option)
                    }
                    else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAns,R.drawable.correct_option)
                    if(mCurrentPostion==mQuestionList!!.size){
                        btnSubmitQuestions?.text="Finish"
                    }
                    else{
                        btnSubmitQuestions?.text="Go to Next Quetion"
                    }
                    mCurrentSelectedOption=0
                }
            }
        }
    }
    private fun answerView(ans:Int,drawableView:Int){
        when(ans){
            1->{
                tvOptionOne?.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                tvOptionTwo?.background=ContextCompat.getDrawable(this@quizQestionActivity,drawableView)
            }
            3->{
                tvOptionThree?.background=ContextCompat.getDrawable(this@quizQestionActivity,drawableView)
            }
            4->{
                tvOptionFour?.background=ContextCompat.getDrawable(this@quizQestionActivity,drawableView)
            }
        }
    }
}