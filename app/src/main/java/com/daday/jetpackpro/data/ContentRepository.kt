package com.daday.jetpackpro.data

import androidx.lifecycle.LiveData
import com.daday.jetpackpro.data.source.local.LocalDataSource
import com.daday.jetpackpro.data.source.local.entity.MovieEntity
import com.daday.jetpackpro.data.source.local.entity.TvShowEntity
import com.daday.jetpackpro.data.source.remote.ApiResponse
import com.daday.jetpackpro.data.source.remote.RemoteDataSource
import com.daday.jetpackpro.data.source.remote.response.ContentResponse
import com.daday.jetpackpro.utils.AppExecutors
import com.daday.jetpackpro.vo.Resource

class ContentRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ContentDataSource {

    companion object {
        @Volatile
        private var instance: ContentRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): ContentRepository =
            instance ?: synchronized(this) {
                instance ?: ContentRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllMovie(): LiveData<Resource<List<MovieEntity>>> {
        return object :
            NetworkBoundResource<List<MovieEntity>, List<ContentResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<MovieEntity>> =
                localDataSource.getMovie()

            override fun shouldFetch(data: List<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<ContentResponse>>> =
                remoteDataSource.getMovie()

            public override fun saveCallResult(contentResponse: List<ContentResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in contentResponse) {
                    val movie = MovieEntity(
                        response.id,
                        response.title,
                        response.releaseDate,
                        response.rating,
                        response.overview,
                        response.imagePath
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTvShow(): LiveData<Resource<List<TvShowEntity>>> {
        return object :
            NetworkBoundResource<List<TvShowEntity>, List<ContentResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<TvShowEntity>> =
                localDataSource.getTvShow()

            override fun shouldFetch(data: List<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<ContentResponse>>> =
                remoteDataSource.getTvSHow()

            public override fun saveCallResult(contentResponse: List<ContentResponse>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in contentResponse) {
                    val tvShow = TvShowEntity(
                        response.id,
                        response.title,
                        response.releaseDate,
                        response.rating,
                        response.overview,
                        response.imagePath
                    )
                    tvShowList.add(tvShow)
                }
                localDataSource.insertTvShow(tvShowList)
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

    fun getMovieFavorite(): LiveData<List<MovieEntity>> =
        localDataSource.getMovieFavorite()

    fun getTvShowFavorite(): LiveData<List<TvShowEntity>> =
        localDataSource.getTvShowFavorite()
}