package com.daday.jetpackpro.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.daday.jetpackpro.data.source.local.LocalDataSource
import com.daday.jetpackpro.data.source.local.entity.MovieEntity
import com.daday.jetpackpro.data.source.local.entity.TvShowEntity
import com.daday.jetpackpro.data.source.remote.RemoteDataSource
import com.daday.jetpackpro.utils.AppExecutors
import com.daday.jetpackpro.utils.DataDummy
import com.daday.jetpackpro.utils.LiveDataTestUtil
import com.daday.jetpackpro.utils.PagedListUtil
import com.daday.jetpackpro.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class ContentRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val contentRepository = FakeContentRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponses[0].id
    private val tvShowResponses = DataDummy.generateRemoteDummyTvShows()
    private val tvShowId = tvShowResponses[0].id


    @Test
    fun getAllMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getMovie()).thenReturn(dataSourceFactory)
        contentRepository.getAllMovie()


        val dataEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getMovie()
        assertNotNull(dataEntities.data)
        assertEquals(movieResponses.size.toLong(), dataEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getTvShow()).thenReturn(dataSourceFactory)
        contentRepository.getAllTvShow()

        val dataEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getTvShow()
        assertNotNull(dataEntities.data)
        assertEquals(tvShowResponses.size.toLong(), dataEntities.data?.size?.toLong())
    }

    @Test
    fun getMovieDetail() {
        val dummyEntity = MutableLiveData<MovieEntity>()
        dummyEntity.value = DataDummy.generateDummyMovieDetail(DataDummy.generateDummyMovies()[0], false)
        `when`(local.getMovieDetail(movieId)).thenReturn(dummyEntity)

        val contentEntities = LiveDataTestUtil.getValue(contentRepository.getMovieDetail(movieId))
        verify(local).getMovieDetail(movieId)
        assertNotNull(contentEntities.data)
        assertNotNull(contentEntities.data?.title)
        assertEquals(movieResponses[0].title, contentEntities.data?.title)
    }

    @Test
    fun getTvShowDetail() {
        val dummyEntity = MutableLiveData<TvShowEntity>()
        dummyEntity.value = DataDummy.generateDummyTvShowDetail(DataDummy.generateDummyTvShows()[0], false)
        `when`(local.getTvShowDetail(tvShowId)).thenReturn(dummyEntity)

        val contentEntities = LiveDataTestUtil.getValue(contentRepository.getTvShowDetail(tvShowId))
        verify(local).getTvShowDetail(tvShowId)

        assertNotNull(contentEntities.data)
        assertNotNull(contentEntities.data?.title)
        assertEquals(tvShowResponses[0].title, contentEntities.data?.title)
    }

    @Test
    fun getFavoriteMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getMovieFavorite()).thenReturn(dataSourceFactory)
        contentRepository.getFavoriteMovie()

        val contentEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getMovieFavorite()
        assertNotNull(contentEntities)
        assertEquals(movieResponses.size.toLong(), contentEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getTvShowFavorite()).thenReturn(dataSourceFactory)
        contentRepository.getFavoriteTvShow()

        val contentEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getTvShowFavorite()
        assertNotNull(contentEntities)
        assertEquals(tvShowResponses.size.toLong(), contentEntities.data?.size?.toLong())
    }
}