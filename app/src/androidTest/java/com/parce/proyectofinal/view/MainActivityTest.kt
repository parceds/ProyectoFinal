package com.parce.proyectofinal.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.parce.proyectofinal.R
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)
    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun mainActivity_CompareEmptyStrings(){
        Espresso.onView(
            ViewMatchers.withId(R.id.btnCompare)
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.tvResult)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Los textos son iguales")
            )
        )
    }

    @Test
    fun mainActivity_CompareEqualStrings(){
        Espresso.onView(
            ViewMatchers.withId(R.id.etTextA)
        ).perform(
            ViewActions.typeText("Digitall-Soft")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.etTextB)
        ).perform(
            ViewActions.typeText("Digitall-Soft")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.btnCompare)
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.tvResult)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Los textos son iguales")
            )
        )
    }

    @Test
    fun mainActivity_CompareDistincStrings(){
        Espresso.onView(
            ViewMatchers.withId(R.id.etTextA)
        ).perform(
            ViewActions.typeText("Digitall-Soft")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.etTextB)
        ).perform(
            ViewActions.typeText("Digital-Soft")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.btnCompare)
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.tvResult)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Los textos son diferentes")
            )
        )
    }
}