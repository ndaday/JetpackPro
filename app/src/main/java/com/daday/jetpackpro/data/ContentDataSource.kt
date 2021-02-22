package com.daday.jetpackpro.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.daday.jetpackpro.data.source.local.entity.MovieEntity
import com.daday.jetpackpro.data.source.local.entity.TvShowEntity
import com.daday.jetpackpro.vo.Resource

interface ContentDataSource {
    fun getAllMovie(): LiveData<Resource<PagedList<MovieEntity>>>
    fun getAllTvShow(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getMovieDetail(movieId: String): LiveData<Resource<MovieEntity>>
    fun getTvShowDetail(tvShowId: String): LiveData<Resource<TvShowEntity>>

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>>
    fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>>

    fun setMovieFavorite(content: MovieEntity, state: Boolean)
    fun setTvShowFavorite(content: TvShowEntity, state: Boolean)
}