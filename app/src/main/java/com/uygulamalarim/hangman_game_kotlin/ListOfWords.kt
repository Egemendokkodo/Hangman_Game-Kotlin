package com.uygulamalarim.hangman_game_kotlin

import java.lang.StringBuilder

class ListOfWords {
    fun getFruits():List<String>{
        var list = mutableListOf<String>()
        list.addAll(listOf("apple","banana","watermelon"))
        return list
    }
    fun getCities():List<String>{
        val list = mutableListOf<String>()
        list.addAll(listOf("Istanbul","London","Cairo"))
        return list
    }
    fun getJobs():List<String>{
        val list = mutableListOf<String>()
        list.addAll(listOf("Doctor","Engineer","Driver"))
        return list
    }
    fun getPlanets():List<String>{
        val list = mutableListOf<String>()
        list.addAll(listOf("Earth","Jupiter","Saturn"))
        return list
    }
}