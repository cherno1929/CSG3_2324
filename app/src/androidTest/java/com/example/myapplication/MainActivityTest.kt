package com.example.myapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {
    @Test
    fun onCreate_mainActivityInitializesCorrectly() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.trichTeam)).check(matches(isDisplayed()))
    }
    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun onClick_imageViewStartsMainMenuActivity() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.trichTeam)).perform(click())
        intended(hasComponent(MainMenu::class.java.name))
    }

}