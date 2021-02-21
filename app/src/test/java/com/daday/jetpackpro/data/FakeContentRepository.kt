package com.daday.jetpackpro.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.daday.jetpackpro.data.source.local.entity.DataEntity
import com.daday.jetpackpro.data.source.remote.RemoteDataSource
import com.daday.jetpackpro.data.source.remote.response.ContentResponse

class FakeContentRepository (private val remoteDataSource: RemoteDataSource) : ContentDataSource {

    override fun getAllMovie(): LiveData<List<DataEntity>> {
        val movieResults = MutableLiveData<List<DataEntity>>()
        remoteDataSource.getMovie(object : RemoteDataSource.LoadMovieCallback{
            override fun onAllMovieReceived(movieResponses: List<ContentResponse>) {
                val movieList = ArrayList<DataEntity>()
                for (response in movieResponses){
                    val movie = DataEntity(
                        response.id,
                        response.title,
                        response.releaseDate,
                        response.rating,
                        response.overview,
                        response.imagePath
                    )
                    movieList.add(movie)
                }
                movieResults.postValue(movieList)
            }
        })
        return movieResults
    }

    override fun getAllTvShow(): LiveData<List<DataEntity>> {
        val tvShowResults = MutableLiveData<List<DataEntity>>()
        remoteDataSource.getTvSHow(object : RemoteDataSource.LoadTvShowCallback{
            override fun onAllTvShowReceived(tvShowResponses: List<ContentResponse>) {
                val tvShowList = ArrayList<DataEntity>()
                for (response in tvShowResponses){
                    val tvShow = DataEntity(
                        response.id,
                        response.title,
                        response.releaseDate,
                        response.rating,
                        response.overview,
                        response.imagePath
                    )
                    tvShowList.add(tvShow)
                }
                tvShowResults.postValue(tvShowList)
            }
        })
        return tvShowResults
    }

    override fun getMovieDetail(movieId: String): LiveData<DataEntity> {
        val movieResult = MutableLiveData<DataEntity>()
        remoteDataSource.getMovie(object : RemoteDataSource.LoadMovieCallback{
            override fun onAllMovieReceived(movieResponses: List<ContentResponse>) {
                lateinit var movie: DataEntity
                for (response in movieResponses){
                    if (response.id == movieId){
                        movie = DataEntity(
                            response.id,
                            response.title,
                            response.releaseDate,
                            response.rating,
                            response.overview,
                            response.imagePath)
                    }
                }
                movieResult.postValue(movie)
            }
        })
        return movieResult
    }

    override fun getTvShowDetail(tvShowId: String): LiveData<DataEntity> {
        val tvshowResult = MutableLiveData<DataEntity>()
        remoteDataSource.getTvSHow(object : RemoteDataSource.LoadTvShowCallback{
            override fun onAllTvShowReceived(tvShowResponses: List<ContentResponse>) {
                lateinit var tvShow: DataEntity
                for (response in tvShowResponses){
                    if (response.id == tvShowId){
                        tvShow = DataEntity(
                            response.id,
                            response.title,
                            response.releaseDate,
                            response.rating,
                            response.overview,
                            response.imagePath)
                    }
                }
                tvshowResult.postValue(tvShow)
            }
        })
        return tvshowResult
    }
}