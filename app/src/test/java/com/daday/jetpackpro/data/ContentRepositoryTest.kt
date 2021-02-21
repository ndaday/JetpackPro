package com.daday.jetpackpro.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.daday.jetpackpro.data.source.remote.RemoteDataSource
import com.daday.jetpackpro.utils.DataDummy
import com.daday.jetpackpro.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class ContentRepositoryTest {

    @get:Rule
    var instantTaskExedcutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val contentRepository = FakeContentRepository(remote)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponses[0].id
    private val tvShowResponses = DataDummy.generateRemoteDummyTvShows()
    private val tvShowId = tvShowResponses[0].id


    @Test
    fun getAllMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback)
                .onAllMovieReceived(movieResponses)
            null
        }.`when`(remote).getMovie(any())
        val dataEntities = LiveDataTestUtil.getValue(contentRepository.getAllMovie())
        verify(remote).getMovie(any())
        assertNotNull(dataEntities)
        assertEquals(movieResponses.size.toLong(), dataEntities.size.toLong())
    }

    @Test
    fun getAllTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(tvShowResponses)
            null
        }.`when`(remote).getTvSHow(any())
        val dataEntities = LiveDataTestUtil.getValue(contentRepository.getAllTvShow())
        verify(remote).getTvSHow(any())
        assertNotNull(dataEntities)
        assertEquals(tvShowResponses.size.toLong(), dataEntities.size.toLong())
    }

    @Test
    fun getMovieDetail() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback)
                .onAllMovieReceived(movieResponses)
            null
        }.`when`(remote).getMovie(any())

        val contentEntities = LiveDataTestUtil.getValue(contentRepository.getMovieDetail(movieId.toString()))

        verify(remote).getMovie(any())

        assertNotNull(contentEntities)
        assertNotNull(contentEntities.title)
        assertEquals(movieResponses[0].title, contentEntities.title)
    }

    @Test
    fun getTvShowDetail() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(tvShowResponses)
            null
        }.`when`(remote).getTvSHow(any())

        val contentEntities = LiveDataTestUtil.getValue(contentRepository.getTvShowDetail(tvShowId.toString()))

        verify(remote).getTvSHow(any())

        assertNotNull(contentEntities)
        assertNotNull(contentEntities.title)
        assertEquals(tvShowResponses[0].title, contentEntities.title)
    }
}