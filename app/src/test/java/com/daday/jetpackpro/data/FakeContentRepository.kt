package com.daday.jetpackpro.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.daday.jetpackpro.data.source.local.LocalDataSource
import com.daday.jetpackpro.data.source.local.entity.MovieEntity
import com.daday.jetpackpro.data.source.local.entity.TvShowEntity
import com.daday.jetpackpro.data.source.remote.ApiResponse
import com.daday.jetpackpro.data.source.remote.RemoteDataSource
import com.daday.jetpackpro.data.source.remote.response.ContentResponse
import com.daday.jetpackpro.utils.AppExecutors
import com.daday.jetpackpro.vo.Resource

class FakeContentRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ContentDataSource {

    override fun getAllMovie(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<ContentResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getMovie(), config).build()

            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ContentResponse>>> =
                remoteDataSource.getMovie()


            override fun saveCallResult(contentResponses: List<ContentResponse>) {
                val contentList = ArrayList<MovieEntity>()
                for (response in contentResponses) {
                    val content = MovieEntity(
                        response.id,
                        response.title,
                        response.releaseDate,
                        response.overview,
                        response.rating,
                        response.imagePath,
                        false
                    )
                    contentList.add(content)
                }

                localDataSource.insertMovie(contentList)
            }
        }.asLiveData()
    }

    override fun getAllTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object :
            NetworkBoundResource<PagedList<TvShowEntity>, List<ContentResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getTvShow(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ContentResponse>>> =
                remoteDataSource.getMovie()

            override fun saveCallResult(contentResponses: List<ContentResponse>) {
                val contentList = ArrayList<TvShowEntity>()
                for (response in contentResponses) {
                    val content = TvShowEntity(
                        response.id,
                        response.title,
                        response.releaseDate,
                        response.overview,
                        response.rating,
                        response.imagePath,
                        false
                    )
                    contentList.add(content)
                }

                localDataSource.insertTvShow(contentList)
            }

        }.asLiveData()
    }

    override fun getMovieDetail(movieId: String): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, List<ContentResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getMovieDetail(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<ContentResponse>>> =
                remoteDataSource.getMovieDetail(movieId)

            override fun saveCallResult(movieResponses: List<ContentResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in movieResponses) {
                    val course = MovieEntity(
                        response.id,
                        response.title,
                        response.releaseDate,
                        response.rating,
                        response.overview,
                        response.overview,
                        false)

                    movieList.add(course)
                }

                localDataSource.insertMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getTvShowDetail(tvShowId: String): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, List<ContentResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowEntity> =
                localDataSource.getTvShowDetail(tvShowId)

            override fun shouldFetch(data: TvShowEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<ContentResponse>>> =
                remoteDataSource.getTvShowDetail(tvShowId)

            override fun saveCallResult(tvShowResponses: List<ContentResponse>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in tvShowResponses) {
                    val course = TvShowEntity(
                        response.id,
                        response.title,
                        response.releaseDate,
                        response.rating,
                        response.overview,
                        response.overview,
                        false)

                    tvShowList.add(course)
                }

                localDataSource.insertTvShow(tvShowList)
            }
        }.asLiveData()
    }

    override fun setMovieFavorite(content: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(content, state) }

    override fun setTvShowFavorite(content: TvShowEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setTvShowFavorite(content, state) }

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getMovieFavorite(), config).build()
    }

    override fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getTvShowFavorite(), config).build()
    }
}