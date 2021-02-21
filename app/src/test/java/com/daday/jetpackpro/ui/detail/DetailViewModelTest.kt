package com.daday.jetpackpro.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.daday.jetpackpro.data.ContentRepository
import com.daday.jetpackpro.data.source.local.entity.DataEntity
import com.daday.jetpackpro.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
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
    private lateinit var contentObserver: Observer<DataEntity>

    @Before
    fun setup() {
        viewModel = DetailViewModel(contentRepository)
        viewModel.setMovieId(movieId)
        viewModel.setTvShowId(tvShowId)
    }

    @Test
    fun getMovie() {
        val content = MutableLiveData<DataEntity>()
        content.value = dummyMovie

        `when`(contentRepository.getMovieDetail(movieId)).thenReturn(content)
        val movieEntities = viewModel.getMovieDetail().value as DataEntity
        verify(contentRepository).getMovieDetail(movieId)
        assertNotNull(movieEntities)
        assertEquals(dummyMovie.id, movieEntities.id)
        assertEquals(dummyMovie.title, movieEntities.title)
        assertEquals(dummyMovie.releaseDate, movieEntities.releaseDate)
        assertEquals(dummyMovie.rating, movieEntities.rating)
        assertEquals(dummyMovie.overviews, movieEntities.overviews)
        assertEquals(dummyMovie.imagePath, movieEntities.imagePath)

        viewModel.getMovieDetail().observeForever(contentObserver)
        verify(contentObserver).onChanged(dummyMovie)
    }

    @Test
    fun getTvShow() {
        val content = MutableLiveData<DataEntity>()
        content.value = dummyTvShow

        `when`(contentRepository.getTvShowDetail(tvShowId)).thenReturn(content)
        val tvShowEntities = viewModel.getTvShowDetail().value as DataEntity
        verify(contentRepository).getTvShowDetail(tvShowId)
        assertNotNull(tvShowEntities)
        assertEquals(dummyTvShow.id, tvShowEntities.id)
        assertEquals(dummyTvShow.title, tvShowEntities.title)
        assertEquals(dummyTvShow.releaseDate, tvShowEntities.releaseDate)
        assertEquals(dummyTvShow.rating, tvShowEntities.rating)
        assertEquals(dummyTvShow.overviews, tvShowEntities.overviews)
        assertEquals(dummyTvShow.imagePath, tvShowEntities.imagePath)

        viewModel.getTvShowDetail().observeForever(contentObserver)
        verify(contentObserver).onChanged(dummyTvShow)
    }
}