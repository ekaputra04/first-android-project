package com.example.belajar_android_dasar

import kotlin.random.Random

object Game {
    private val rules = mapOf(
        "batu-gunting" to true,
        "batu-kertas" to false,
        "gunting-kertas" to true,
        "gunting-batu" to false,
        "kertas-batu" to true,
        "kertas-gunting" to false
    )

    private val options = listOf("batu", "gunting", "kertas")

    private val optionDrawable= mapOf(
        "batu" to R.drawable.batu,
        "kertas" to R.drawable.kertas,
        "gunting" to R.drawable.gunting
    )

    fun pickRandomOption(): String = options[Random.nextInt(0, 3)]

    fun pickDrawable(option: String): Int = optionDrawable[option]!!

    fun isDraw(from: String, to: String): Boolean = from == to

    fun isWin(from: String, to: String): Boolean = rules["$from-$to"]!!
}