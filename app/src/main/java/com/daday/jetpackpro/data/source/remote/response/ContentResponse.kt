package com.daday.jetpackpro.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ContentResponse(
	val id: String,
	val title: String,
	val releaseDate: String,
	val rating: String,
	val overview: String,
	val imagePath: String,
) : Parcelable
