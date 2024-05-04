package com.example.myapplication

import android.view.View
import android.widget.LinearLayout
import androidx.test.espresso.Espresso
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.myapplication.MainMenu
import org.junit.Rule
import org.junit.Test
import com.example.myapplication.R
import org.hamcrest.Matcher

class ResetPlayUITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainMenu::class.java)

    @Test
    fun testPlay() {
        Espresso.onView(ViewMatchers.withId(R.id.butnplay))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.button_vsPMach))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.tableroLayout)).perform(
            ViewActions.actionWithAssertions(object : ViewAction {
                override fun getDescription(): String {
                    return "Click en ficha del tablero"
                }

                override fun getConstraints(): Matcher<View> {
                    return ViewMatchers.isAssignableFrom(LinearLayout::class.java)
                }

                override fun perform(uiController: UiController?, view: View?) {
                    val tableroLayout = view as LinearLayout
                    val fila = tableroLayout.getChildAt(0) as LinearLayout
                    val ficha = fila.getChildAt(0)
                    ficha.performClick()
                }
            })
        )

        Espresso.onView(ViewMatchers.withId(R.id.reiniciar))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())
    }
}