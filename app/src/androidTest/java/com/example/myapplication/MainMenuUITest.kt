package com.example.myapplication

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.myapplication.MainMenu
import org.junit.Rule
import org.junit.Test
import com.example.myapplication.R

class MainMenuUITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainMenu::class.java)

    @Test
    fun testButtons() {
        Espresso.onView(ViewMatchers.withId(R.id.butnplay))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())
        Espresso.pressBack()

        Espresso.onView(ViewMatchers.withId(R.id.butnhist))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())
        Espresso.pressBack()

        Espresso.onView(ViewMatchers.withId(R.id.butnconf))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())
        Espresso.pressBack()
    }
}
