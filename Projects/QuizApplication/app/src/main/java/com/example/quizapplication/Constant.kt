package com.example.quizapplication

object Constant {
    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_question"
    const val CORRECT_ANSWER:String="correct_answer"

    fun getQuestion():ArrayList<Question>{
        val questionList=ArrayList<Question>()
        val que1=Question(
            1,"What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina","Australia","Armenia","Austria",
            1
        )
        questionList.add(que1)

        val que2=Question(
            2,"What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Afghanistan","Australia","Armenia","Austria",
            2
        )
        questionList.add(que2)

        val que3=Question(
            3,"What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Argentina","Australia","Armenia","Belgium",
            4
        )
        questionList.add(que3)

        val que4=Question(
            4,"What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Argentina","Brazil","Armenia","Austria",
            2
        )
        questionList.add(que4)

        val que5=Question(
            5,"What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Denmark","Australia","Armenia","Austria",
            1
        )
        questionList.add(que5)

        val que6=Question(
            6,"What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Argentina","Australia","Fiji","Austria",
            3
        )
        questionList.add(que6)

        val que7=Question(
            7,"What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Argentina","Australia","India","Austria",
            3
        )
        questionList.add(que7)

        val que8=Question(
            8,"What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany","Australia","Armenia","Austria",
            1
        )
        questionList.add(que8)

        val que9=Question(
            9,"What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Argentina","Australia","Armenia","Kuwait",
            4
        )
        questionList.add(que9)

        val que10=Question(
            10,"What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Argentina","Australia","New Zealand","Austria",
            3
        )
        questionList.add(que10)
        return questionList
    }

    
}