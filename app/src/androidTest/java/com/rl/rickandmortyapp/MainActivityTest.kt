package com.rl.rickandmortyapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    //Step 1: creating global veriable

    @get:Rule var activityScenarioRule = activityScenarioRule<MainActivity>()

    //Step 2: checking if our main activity layout is displayed or is visable to the user


    @Test
    fun checkActivityVisibilityTitle(){
        onView(withText("Rick And Morty"))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkAllButtonsOnHomeScreen(){
        onView(withId(R.id.characters_button))
            .check(matches(isDisplayed()))

        onView(withId(R.id.episodes_button))
            .check(matches(isDisplayed()))

        onView(withId(R.id.locations_button))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkNavigationBetweenHomeScreenAndEpisodesFragment(){
        onView(withId(R.id.episodes_button))
            .perform(click())

        onView(withId(R.id.layout_episodes))
            .check(matches(isDisplayed()))
    }
}