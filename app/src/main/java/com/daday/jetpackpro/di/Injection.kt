package com.daday.jetpackpro.di

import android.content.Context
import com.daday.jetpackpro.data.ContentRepository
import com.daday.jetpackpro.data.source.local.LocalDataSource
import com.daday.jetpackpro.data.source.local.room.ContentDatabase
import com.daday.jetpackpro.data.source.remote.RemoteDataSource
import com.daday.jetpackpro.utils.AppExecutors
import com.daday.jetpackpro.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): ContentRepository {

        val database = ContentDatabase.getInstance(context)

        val remoteRepository = RemoteDataSource.getInstance(JsonHelper(context))

        val localDataSource = LocalDataSource.getInstance(database.contentDao())
        val appExecutors = AppExecutors()

        return ContentRepository.getInstance(remoteRepository, localDataSource, appExecutors)
    }
}