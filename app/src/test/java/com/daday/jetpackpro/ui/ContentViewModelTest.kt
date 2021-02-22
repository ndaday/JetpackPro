package com.daday.jetpackpro.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.daday.jetpackpro.data.ContentRepository
import com.daday.jetpackpro.data.source.local.entity.MovieEntity
import com.daday.jetpackpro.data.source.local.entity.TvShowEntity
import com.daday.jetpackpro.vo.Resource
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
    private lateinit var observerMovie: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var observerTvShow: Observer<Resource<PagedList<TvShowEntity>>>

    @Mock
    private lateinit var observerFavMovie: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var observerFavTvShow: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var pagedListMovie: PagedList<MovieEntity>

    @Mock
    private lateinit var pagedListTvShow: PagedList<TvShowEntity>

    @Before
    fun setup() {
        viewModelTest = ContentViewModel(contentRepository)
    }

    @Test
    fun getListMovie() {
        val dummyMovie = Resource.success(pagedListMovie)
        `when`(dummyMovie.data?.size).thenReturn(10)
        val movie = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movie.value = dummyMovie

        `when`(contentRepository.getAllMovie()).thenReturn(movie)
        val movieEntities = viewModelTest.getListMovie().value?.data
        verify(contentRepository).getAllMovie()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModelTest.getListMovie().observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)
    }

    @Test
    fun getListTvShow() {
        val dummyTv = Resource.success(pagedListTvShow)
        `when`(dummyTv.data?.size).thenReturn(10)
        val tv = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        tv.value = dummyTv

        `when`(contentRepository.getAllTvShow()).thenReturn(tv)
        val tvEntities = viewModelTest.getListTvShow().value?.data
        verify(contentRepository).getAllTvShow()
        assertNotNull(tvEntities)
        assertEquals(10, tvEntities?.size)

        viewModelTest.getListTvShow().observeForever(observerTvShow)
        verify(observerTvShow).onChanged(dummyTv)
    }

    @Test
    fun getMovieFav(){
        val dummyContent = pagedListMovie
        `when`(dummyContent.size).thenReturn(10)
        val content = MutableLiveData<PagedList<MovieEntity>>()
        content.value = dummyContent

        `when`(contentRepository.getFavoriteMovie()).thenReturn(content)
        val contentEntities = viewModelTest.getMovieFav().value
        verify(contentRepository).getFavoriteMovie()
        assertNotNull(contentEntities)
        assertEquals(10, contentEntities?.size)

        viewModelTest.getMovieFav().observeForever(observerFavMovie)
        verify(observerFavMovie).onChanged(dummyContent)
    }

    @Test
    fun getTvShowFav(){
        val dummyContent = pagedListTvShow
        `when`(dummyContent.size).thenReturn(10)
        val content = MutableLiveData<PagedList<TvShowEntity>>()
        content.value = dummyContent

        `when`(contentRepository.getFavoriteTvShow()).thenReturn(content)
        val contentEntities = viewModelTest.getTvShowFav().value
        verify(contentRepository).getFavoriteTvShow()
        assertNotNull(contentEntities)
        assertEquals(10, contentEntities?.size)

        viewModelTest.getTvShowFav().observeForever(observerFavTvShow)
        verify(observerFavTvShow).onChanged(dummyContent)
    }
}