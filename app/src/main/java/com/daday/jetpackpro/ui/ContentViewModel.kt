package com.daday.jetpackpro.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.daday.jetpackpro.data.ContentRepository
import com.daday.jetpackpro.data.source.local.entity.MovieEntity
import com.daday.jetpackpro.data.source.local.entity.TvShowEntity
import com.daday.jetpackpro.vo.Resource

class ContentViewModel (private val contentRepository: ContentRepository) : ViewModel() {
    fun getListMovie(): LiveData<Resource<List<MovieEntity>>> = contentRepository.getAllMovie()
    fun getListTvShow(): LiveData<Resource<List<TvShowEntity>>> = contentRepository.getAllTvShow()

    fun getMovieFav(): LiveData<List<MovieEntity>> {
        return contentRepository.getMovieFavorite()
    }

    fun getTvShowFav(): LiveData<List<TvShowEntity>> {
        return contentRepository.getTvShowFavorite()
    }
}