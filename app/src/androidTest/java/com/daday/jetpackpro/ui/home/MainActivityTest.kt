package com.daday.jetpackpro.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.daday.jetpackpro.R
import com.daday.jetpackpro.utils.DataDummy
import com.daday.jetpackpro.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_Movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_Movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size)
        )
    }

    @Test
    fun loadTvShow() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size)
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_Movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )
        onView(withId(R.id.tv_item_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tv_item_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_date)).check(matches(withText(dummyMovie[0].releaseDate)))
        onView(withId(R.id.tv_item_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_rating)).check(matches(withText(dummyMovie[0].rating)))
        onView(withId(R.id.tv_item_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_overview)).check(matches(withText(dummyMovie[0].overviews)))
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )
        onView(withId(R.id.tv_item_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_title)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.tv_item_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_date)).check(matches(withText(dummyTvShow[0].releaseDate)))
        onView(withId(R.id.tv_item_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_rating)).check(matches(withText(dummyTvShow[0].rating)))
        onView(withId(R.id.tv_item_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_overview)).check(matches(withText(dummyTvShow[0].overviews)))
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
    }
}