package com.daday.jetpackpro.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.daday.jetpackpro.data.ContentRepository
import com.daday.jetpackpro.data.source.local.entity.MovieEntity
import com.daday.jetpackpro.data.source.local.entity.TvShowEntity
import com.daday.jetpackpro.vo.Resource

class DetailViewModel (private val contentRepository: ContentRepository) : ViewModel(){

    private val movieId = MutableLiveData<String>()
    private val tvShowId = MutableLiveData<String>()

    fun setMovieId(movieId: String) {
        this.movieId.value = movieId
    }

    fun setTvShowId(tvShowId: String) {
        this.tvShowId.value = tvShowId
    }

    var contentMovie: LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) { mMovieId ->
        contentRepository.getMovieDetail(mMovieId)
    }
    var contentTvShow: LiveData<Resource<TvShowEntity>> = Transformations.switchMap(tvShowId) { mTvShowId ->
        contentRepository.getTvShowDetail(mTvShowId)
    }

    fun setBookmarkMovie() {
        val movieResource = contentMovie.value
        if (movieResource != null) {
            val movieDetail = movieResource.data

            if (movieDetail != null) {
                val dataEntity = MovieEntity(movieDetail.id,movieDetail.title,movieDetail.releaseDate,movieDetail.rating,movieDetail.overviews,movieDetail.imagePath)
                val newState = !movieDetail.favorite
                contentRepository.setMovieFavorite(dataEntity, newState)
            }
        }
    }

    fun setBookmarkTvShow() {
        val tvResource = contentTvShow.value
        if (tvResource != null) {
            val tvDetail = tvResource.data

            if (tvDetail != null) {
                val dataEntity = TvShowEntity(tvDetail.id,tvDetail.title,tvDetail.releaseDate,tvDetail.rating,tvDetail.overviews,tvDetail.imagePath)
                val newState = !tvDetail.favorite
                contentRepository.setTvShowFavorite(dataEntity, newState)
            }
        }
    }
}