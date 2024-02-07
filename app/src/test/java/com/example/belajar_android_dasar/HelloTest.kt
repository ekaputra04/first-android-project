package com.example.belajar_android_dasar

import org.junit.Assert
import org.junit.Test

class HelloTest {
    @Test
    fun testHello() {
        val result = Hello.sayHello("Eka")

        Assert.assertEquals("Hello Eka", result)
    }
}