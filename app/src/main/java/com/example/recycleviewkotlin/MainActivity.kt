package com.example.recycleviewkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewkotlin.DetailActivity
import com.example.recycleviewkotlin.adapter

class MainActivity : AppCompatActivity() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageList = listOf<hero>(
            hero(R.drawable.superman_in_batman_v_superman_dawn_of_justice_1600x900,
                "Superman",
                "p",
            ),
            hero(R.drawable.batman_ben_affleck_20210630032211,
                "Batman",
                "p",
            ),
            hero(R.drawable._959270282,
                "Hulk",
                "p",
            ),
            hero(R.drawable._202748_5536279855_black_ratio_16x9,
                "Black Panther",
                "p",
            ),
            hero(R.drawable.spiderman_20201013040553,
                "SpiderMan",
                "p",
            ),
            hero(R.drawable.c9bdb9441a642b9ee1a6c83bd6dc4e77hemsworth_dark_world,
                "Thor",
                "p",
            )


        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_hero)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter(this, imageList) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)


        }
    }
}