package com.example.myapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import org.junit.Test
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

class PantallaOpcionesTest {
    @Test
    fun onCreate_pantallaOpcionesInitializesCorrectly() {
        ActivityScenario.launch(PantallaOpciones::class.java)
        onView(withId(R.id.volumeSeekBar)).check(matches(isDisplayed()))
    }
    @Test
    fun onClick_creditsButtonShowsDialog() {
        ActivityScenario.launch(PantallaOpciones::class.java)
        onView(withId(R.id.credits)).perform(click())
        onView(withText("Esta aplicación ha sido creada por el equipo de TriquiTech:\n\nJosé, Jorge, Paula, Pedro, Álvaro, Younes, Guillermo, Eloy y Gonzalo")).check(matches(isDisplayed()))
    }
}