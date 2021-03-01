package com.daday.jetpackpro.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.daday.jetpackpro.data.ContentRepository
import com.daday.jetpackpro.data.source.local.entity.MovieEntity
import com.daday.jetpackpro.data.source.local.entity.TvShowEntity
import com.daday.jetpackpro.utils.DataDummy
import com.daday.jetpackpro.vo.Resource
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.spy
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Answers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val movieId = dummyMovie.id
    private val tvShowId = dummyTvShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var contentRepository: ContentRepository

    @Mock
    private lateinit var observerMovie: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var observerTvShow: Observer<Resource<TvShowEntity>>

    @Before
    fun setup() {
        viewModel = DetailViewModel(contentRepository)
        viewModel.setMovieId(movieId)
        viewModel.setTvShowId(tvShowId)
    }

    @Test
    fun getMovie() {
        val dummyDetail = Resource.success(DataDummy.generateDummyMovieDetail(dummyMovie, true))
        val content = MutableLiveData<Resource<MovieEntity>>()
        content.value = dummyDetail

        `when`(contentRepository.getMovieDetail(movieId)).thenReturn(content)

        viewModel.contentMovie.observeForever(observerMovie)

        verify(contentRepository).getMovieDetail(movieId)
        verify(observerMovie).onChanged(dummyDetail)
    }

    @Test
    fun getTvShow() {
        val dummyDetail = Resource.success(DataDummy.generateDummyTvShowDetail(dummyTvShow, true))
        val content = MutableLiveData<Resource<TvShowEntity>>()
        content.value = dummyDetail

        `when`(contentRepository.getTvShowDetail(tvShowId)).thenReturn(content)

        viewModel.contentTvShow.observeForever(observerTvShow)

        verify(contentRepository).getTvShowDetail(tvShowId)
        verify(observerTvShow).onChanged(dummyDetail)
    }


    @Test
    fun setFavoriteMovie(){
        val dummyDetail = Resource.success(DataDummy.generateDummyMovieDetail(dummyMovie, true))
        val content = MutableLiveData<Resource<MovieEntity>>()
        val dummy = MutableLiveData<MovieEntity>()
        content.value = dummyDetail
        val dataResource = dummyDetail.data

        if (dataResource != null) {
            val dataEntity = MovieEntity(dataResource.id,dataResource.title,dataResource.releaseDate,dataResource.rating,dataResource.overviews,dataResource.imagePath)
            lenient().`when`(
                spy(contentRepository.setMovieFavorite(dataEntity, true))).thenCallRealMethod()
        }

        viewModel.setFavoriteMovie()
        dummy.value?.let { verify(contentRepository).setMovieFavorite(it, true) }
        verifyNoMoreInteractions(observerMovie)
    }

    @Test
    fun setFavoriteTvShow(){
        val dummyDetail = Resource.success(DataDummy.generateDummyTvShowDetail(dummyTvShow, true))
        val content = MutableLiveData<Resource<TvShowEntity>>()
        val dummy = MutableLiveData<TvShowEntity>()
        content.value = dummyDetail
        val dataResource = dummyDetail.data

        if (dataResource != null) {
            val dataEntity = TvShowEntity(dataResource.id,dataResource.title,dataResource.releaseDate,dataResource.rating,dataResource.overviews,dataResource.imagePath)
            lenient().`when`(
                spy(contentRepository.setTvShowFavorite( dataEntity, true))).thenCallRealMethod()
        }

        viewModel.setFavoriteTvShow()
        dummy.value?.let { verify(contentRepository).setTvShowFavorite(it, true) }
        verifyNoMoreInteractions(observerTvShow)
    }
}