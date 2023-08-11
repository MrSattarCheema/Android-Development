package com.example.topgameapp_cardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/*CardView are new widgets in android that can used to display any sort of data by providing rounded
corners layout. In short: It display item of list view or recycler view in cards*/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView:RecyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        val gamesList:ArrayList<TopGameModel> = ArrayList()
        val g1:TopGameModel= TopGameModel(R.drawable.card1,"Horizon Chase")
        val g2:TopGameModel= TopGameModel(R.drawable.card2,"PUBG")
        val g3:TopGameModel= TopGameModel(R.drawable.card3,"Head Ball 2")
        val g4:TopGameModel= TopGameModel(R.drawable.card4,"FIFA 2020")
        val g5:TopGameModel= TopGameModel(R.drawable.card5,"Fortnite")
        val g6:TopGameModel= TopGameModel(R.drawable.card6,"Hooked on You")
        gamesList.add(g1)
        gamesList.add(g2)
        gamesList.add(g3)
        gamesList.add(g4)
        gamesList.add(g5)
        gamesList.add(g6)
        val adapter=TopGameAdapter(gamesList)
        recyclerView.adapter=adapter
    }
}