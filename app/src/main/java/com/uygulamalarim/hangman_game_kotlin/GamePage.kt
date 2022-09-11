package com.uygulamalarim.hangman_game_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_game_page.*

class GamePage : AppCompatActivity() {
    var life =8
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_page)

        initView()

    }

    fun initView(){
        hiddenText.isEnabled = false
        hiddenText.setTextColor(Color.BLACK)

        hideTheWords()

    }



    private fun hideTheWords(){
        val list=ListOfWords()
        val infoBtn=intent.getIntExtra("a",0)

        var fruit=list.getFruits().random().lowercase()

        var jobs=list.getJobs().random().lowercase()

        var cities=list.getCities().random().lowercase()

        var planets=list.getPlanets().random().lowercase()


        when(infoBtn){
            0->Toast.makeText(applicationContext,"Something Went Wrong!",Toast.LENGTH_LONG).show()
            1->{
                val word =fruit
                val sb=StringBuilder()
                fruit.forEach { char->
                    if(char=='/'){
                        sb.append('/')
                    }else
                        sb.append("*")
                }
                fruit=sb.toString()
                hiddenText.setText(fruit)

                button.setOnClickListener(View.OnClickListener{
                    guessingActions(word,fruit)
                })


            }
            2->{
                val word=jobs
                val sb=StringBuilder()
                jobs.forEach { char->
                    if(char=='/'){
                        sb.append('/')
                    }else
                        sb.append("*")
                }
                jobs=sb.toString()
                hiddenText.setText(jobs)
                button.setOnClickListener(View.OnClickListener{
                    guessingActions(word,jobs)
                })

            }
            3->{
                val word=cities
                val sb=StringBuilder()
                cities.forEach { char->
                    if(char=='/'){
                        sb.append('/')
                    }else
                        sb.append("*")
                }
                cities=sb.toString()
                hiddenText.setText(cities)
                button.setOnClickListener(View.OnClickListener{
                    guessingActions(word,cities)
                })
            }
            4->{
                val word=planets
                val sb=StringBuilder()
                planets.forEach { char->
                    if(char=='/'){
                        sb.append('/')
                    }else
                        sb.append("*")
                }
                planets=sb.toString()
                hiddenText.setText(planets)
                button.setOnClickListener(View.OnClickListener{
                    guessingActions(word,planets)
                })
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun guessingActions(word:String, fruit:String){
        //girdiğimiz harf kelimenin içinde nerede var onu gösterir

        var index=word.indexOf(guessLetter.text.toString(),0,false)
        if (index<0){
            life-=1
            println(life)
            when(life){
                0->{
                    alertDialogLose(word)
                }
                1-> {
                    wrong6.setText(guessLetter.text.toString())
                    leg1.visibility = View.VISIBLE
                }
                2->{
                    wrong5.setText(guessLetter.text.toString())
                    leg2.visibility=View.VISIBLE
                }
                3->{
                    wrong4.setText(guessLetter.text.toString())
                    arm1.visibility=View.VISIBLE}
                4->{
                    wrong3.setText(guessLetter.text.toString())
                    arm2.visibility=View.VISIBLE}
                6->{
                    wrong2.setText(guessLetter.text.toString())
                    body.visibility=View.VISIBLE
                }
                7->{
                    wrong1.setText(guessLetter.text.toString())
                    head.visibility=View.VISIBLE
                }
            }
        }
        else if (hiddenText.text.toString()==word){
            alertDialogWin()
        }
        else{
            while (index>=0){
                hiddenText.setText(hiddenText.text.toString().substring(0, index) + guessLetter.text + hiddenText.text.substring(index + 1))
                index = word.indexOf(guessLetter.text.toString(), index + 1, false)

            }
        }
    }
    fun alertDialogLose(word:String){
        val alertDialog = AlertDialog.Builder(this)
        val intent=Intent(this,MainActivity::class.java)
        alertDialog.setTitle("You Lost the Game")
        alertDialog.setMessage("You are hanged!\nCorrect word was $word")
        alertDialog.setPositiveButton(android.R.string.yes){ dialog, which ->
            startActivity(intent)
        }
        alertDialog.show()
    }
    fun alertDialogWin(){
        val alertDialog = AlertDialog.Builder(this)
        val intent=Intent(this,MainActivity::class.java)
        alertDialog.setTitle("You Won the Game")
        alertDialog.setMessage("Congratulations you won the game!")
        alertDialog.setPositiveButton(android.R.string.yes){ dialog, which ->
            startActivity(intent)
        }
        alertDialog.show()
    }
}











