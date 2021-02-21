package com.daday.jetpackpro.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daday.jetpackpro.R
import com.daday.jetpackpro.databinding.ActivityFavoriteBinding
import com.daday.jetpackpro.ui.home.SectionsPagerAdapter

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(activityFavoriteBinding.root)

        val pagerAdapter = PagerAdapter(this, supportFragmentManager)
        activityFavoriteBinding.viewPager.adapter = pagerAdapter
        activityFavoriteBinding.tabs.setupWithViewPager(activityFavoriteBinding.viewPager)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = getString(R.string.favorite)
    }
}