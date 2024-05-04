package com.example.myapplication


import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(features = ["features"],
    glue = ["com.example.myapplication"])
@SuppressWarnings("unused")

class CucumberSetup {
}