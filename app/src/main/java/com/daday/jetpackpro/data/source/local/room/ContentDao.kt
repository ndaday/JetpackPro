package com.daday.jetpackpro.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.daday.jetpackpro.data.source.local.entity.MovieEntity
import com.daday.jetpackpro.data.source.local.entity.TvShowEntity

@Dao
interface ContentDao {

    @Query("SELECT * FROM movieentities")
    fun getMovie(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM tvshowentities")
    fun getTvShow(): LiveData<List<TvShowEntity>>

    @Transaction
    @Query("SELECT * FROM movieentities WHERE id = :id")
    fun getMovieDetail(id: String): LiveData<MovieEntity>

    @Transaction
    @Query("SELECT * FROM tvshowentities WHERE id = :id")
    fun getTvShowDetail(id: String): LiveData<TvShowEntity>

    @Query("SELECT * FROM movieentities where favorite = 1")
    fun getMovieFavorite(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM tvshowentities where favorite = 1")
    fun getTvShowFavorite(): LiveData<List<TvShowEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(content: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(content: List<TvShowEntity>)

    @Update
    fun updateMovie(content: MovieEntity)

    @Update
    fun updateTvShow(content: TvShowEntity)
}