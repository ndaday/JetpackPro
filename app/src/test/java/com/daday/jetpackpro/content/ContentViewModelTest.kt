package com.daday.jetpackpro.content

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.daday.jetpackpro.data.ContentRepository
import com.daday.jetpackpro.data.source.local.entity.DataEntity
import com.daday.jetpackpro.data.source.local.entity.MovieEntity
import com.daday.jetpackpro.ui.ContentViewModel
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
class ContentViewModelTest {

    private lateinit var viewModelTest: ContentViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var contentRepository: ContentRepository

    @Mock
    private lateinit var observer: Observer<List<DataEntity>>

    @Before
    fun setup() {
        viewModelTest = ContentViewModel(contentRepository)
    }

    @Test
    fun getListMovie() {
        val dummyMovie = DataDummy.generateDummyMovies()
        val movie = MutableLiveData<List<MovieEntity>>()
        movie.value = dummyMovie

        `when`(contentRepository.getAllMovie()).thenReturn(movie)
        val movieEntities = viewModelTest.getListMovie().value
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModelTest.getListMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }

    @Test
    fun getListTvShow() {
        val dummyTv = DataDummy.generateDummyTvShows()
        val tv = MutableLiveData<List<DataEntity>>()
        tv.value = dummyTv

        `when`(contentRepository.getAllTvShow()).thenReturn(tv)
        val tvShowEntities = viewModelTest.getListTvShow().value
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        viewModelTest.getListTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTv)
    }
}