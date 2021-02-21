package com.daday.jetpackpro.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.daday.jetpackpro.ui.ContentViewModel
import com.daday.jetpackpro.data.ContentRepository
import com.daday.jetpackpro.di.Injection
import com.daday.jetpackpro.ui.detail.DetailViewModel

class ViewModelFactory private constructor(private val mContentRepository: ContentRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ContentViewModel::class.java) -> {
                ContentViewModel(mContentRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel (mContentRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}