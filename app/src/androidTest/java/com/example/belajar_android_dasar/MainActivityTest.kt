package com.example.belajar_android_dasar

import androidx.compose.ui.test.hasClickAction
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering.Context

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
//    manual

//    lateinit var mainActivityScenario: ActivityScenario<MainActivity>
//
//    @Before
//    fun setUp(){
//        mainActivityScenario=ActivityScenario.launch(MainActivity::class.java)
//    }
//
//    @After
//    fun tearDown(){
//        mainActivityScenario.close()
//    }


//    menggunakan activity scenario rule

    @get:Rule
    var mainActivityScenarioRule=ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testSayHello(){
//        val context = ApplicationProvider.getApplicationContext<Context>()

        val name="Eka"

        Espresso.onView(ViewMatchers.withId(R.id.nameEditText))
            .perform(ViewActions.typeText(name))

        Espresso.onView(ViewMatchers.withId(R.id.sayHelloButton))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.sayHelloTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Hello $name")))
    }
}