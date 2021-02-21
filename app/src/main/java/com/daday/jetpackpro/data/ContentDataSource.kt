package com.daday.jetpackpro.data

import androidx.lifecycle.LiveData
import com.daday.jetpackpro.data.source.local.entity.MovieEntity
import com.daday.jetpackpro.data.source.local.entity.TvShowEntity
import com.daday.jetpackpro.vo.Resource

interface ContentDataSource {
    fun getAllMovie(): LiveData<Resource<List<MovieEntity>>>
    fun getAllTvShow(): LiveData<Resource<List<TvShowEntity>>>
    fun getMovieDetail(movieId: String): LiveData<Resource<MovieEntity>>
    fun getTvShowDetail(tvShowId: String): LiveData<Resource<TvShowEntity>>
    fun setMovieFavorite(content: MovieEntity, state: Boolean)
    fun setTvShowFavorite(content: TvShowEntity, state: Boolean)
}