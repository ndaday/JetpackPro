package com.daday.jetpackpro.ui.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.daday.jetpackpro.R
import com.daday.jetpackpro.ui.home.SectionsPagerAdapter
import com.daday.jetpackpro.ui.movie.MovieFragment
import com.daday.jetpackpro.ui.tvshow.TvShowFragment

class PagerAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movies, R.string.tvshows)
    }

    override fun getCount(): Int = TAB_TITLES.size

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> MovieFavFragment()
            1 -> TvShowFavFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(
        PagerAdapter.TAB_TITLES[position]
    )
}