package com.daday.jetpackpro.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.daday.jetpackpro.data.source.local.entity.MovieEntity
import com.daday.jetpackpro.data.source.local.entity.TvShowEntity
import com.daday.jetpackpro.data.source.local.room.ContentDao

class LocalDataSource private constructor(private val mContentDao: ContentDao){
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(contentDao: ContentDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(contentDao)
    }

    fun getMovie(): DataSource.Factory<Int, MovieEntity> = mContentDao.getMovie()

    fun getTvShow(): DataSource.Factory<Int, TvShowEntity> = mContentDao.getTvShow()

    fun getMovieDetail(contentId: String): LiveData<MovieEntity> = mContentDao.getMovieDetail(contentId)

    fun getTvShowDetail(contentId: String): LiveData<TvShowEntity> = mContentDao.getTvShowDetail(contentId)

    fun getMovieFavorite(): DataSource.Factory<Int, MovieEntity> = mContentDao.getMovieFavorite()

    fun getTvShowFavorite(): DataSource.Factory<Int, TvShowEntity> = mContentDao.getTvShowFavorite()

    fun insertMovie(content: List<MovieEntity>) = mContentDao.insertMovie(content)

    fun insertTvShow(content: List<TvShowEntity>) = mContentDao.insertTvShow(content)

    fun setMovieFavorite(content: MovieEntity, newState: Boolean) {
        content.favorite = newState
        mContentDao.updateMovie(content)
    }

    fun setTvShowFavorite(content: TvShowEntity, newState: Boolean) {
        content.favorite = newState
        mContentDao.updateTvShow(content)
    }
}