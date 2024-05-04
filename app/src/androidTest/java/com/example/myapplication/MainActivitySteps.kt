package com.example.myapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.junit.Test


class MainActivitySteps {

    @Given("Abro la aplicacion")
    fun clickStart() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @When("Presiono el boton")
    fun clickButton() {
        onView(withId(R.id.trichTeam)).perform(click())
    }

    @Then("Se muestra la pantalla de resultados")
    fun verifyResult() {
        Intents.intended(IntentMatchers.hasComponent(MainMenu::class.java.name))
    }
}