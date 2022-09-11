package com.uygulamalarim.hangman_game_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fruitsBtn.setOnClickListener({
            val intent= Intent(this,GamePage::class.java)
            intent.putExtra("a",1)
            startActivity(intent)
        })
        jobsBtn.setOnClickListener({
            val intent= Intent(this,GamePage::class.java)
            intent.putExtra("a",2)
            startActivity(intent)
        })
        citiesBtn.setOnClickListener({
            val intent= Intent(this,GamePage::class.java)
            intent.putExtra("a",3)
            startActivity(intent)
        })
        planetsBtn.setOnClickListener({
            val intent= Intent(this,GamePage::class.java)
            intent.putExtra("a",4)
            startActivity(intent)
        })


    }
}