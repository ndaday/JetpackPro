package com.daday.jetpackpro.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.daday.jetpackpro.data.ContentRepository
import com.daday.jetpackpro.data.source.local.entity.MovieEntity
import com.daday.jetpackpro.data.source.local.entity.TvShowEntity
import com.daday.jetpackpro.vo.Resource

class ContentViewModel (private val contentRepository: ContentRepository) : ViewModel() {
    fun getListMovie(): LiveData<Resource<PagedList<MovieEntity>>> = contentRepository.getAllMovie()
    fun getListTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> = contentRepository.getAllTvShow()

    fun getMovieFav(): LiveData<PagedList<MovieEntity>> = contentRepository.getFavoriteMovie()
    fun getTvShowFav(): LiveData<PagedList<TvShowEntity>> = contentRepository.getFavoriteTvShow()

    fun setFavoriteMovie(movieEntity: MovieEntity) {
        val newState = !movieEntity.favorite
        contentRepository.setMovieFavorite(movieEntity, newState)
    }

    fun setFavoriteTvShow(tvShowEntity: TvShowEntity) {
        val newState = !tvShowEntity.favorite
        contentRepository.setTvShowFavorite(tvShowEntity, newState)
    }
}