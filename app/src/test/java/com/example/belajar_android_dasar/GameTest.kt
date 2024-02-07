package com.example.belajar_android_dasar

import org.junit.Assert
import org.junit.Test

class GameTest {
    @Test
    fun testPickRandomOption() {
        val options = listOf("batu", "gunting", "kertas")
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
    }

    @Test
    fun testPickDrawable() {
        Assert.assertEquals(R.drawable.batu, Game.pickDrawable("batu"))
        Assert.assertEquals(R.drawable.gunting, Game.pickDrawable("gunting"))
        Assert.assertEquals(R.drawable.kertas, Game.pickDrawable("kertas"))
    }

    @Test
    fun testIsDraw() {
        Assert.assertTrue(Game.isDraw("batu", "batu"))
        Assert.assertTrue(Game.isDraw("gunting", "gunting"))
        Assert.assertTrue(Game.isDraw("kertas", "kertas"))

        Assert.assertFalse(Game.isDraw("batu","gunting"))
        Assert.assertFalse(Game.isDraw("batu","kertas"))
        Assert.assertFalse(Game.isDraw("kertas","gunting"))
    }

    @Test
    fun testIsWin(){
        Assert.assertTrue(Game.isWin("batu", "gunting"))
        Assert.assertTrue(Game.isWin("gunting", "kertas"))
        Assert.assertTrue(Game.isWin("kertas", "batu"))

        Assert.assertFalse(Game.isWin("gunting", "batu"))
        Assert.assertFalse(Game.isWin("kertas", "gunting"))
        Assert.assertFalse(Game.isWin("batu", "kertas"))
    }
}