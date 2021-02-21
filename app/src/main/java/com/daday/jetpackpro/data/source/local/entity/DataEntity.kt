package com.daday.jetpackpro.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contentEntities")
data class DataEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "contentId")
    val id: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: String,

    @ColumnInfo(name = "rating")
    var rating: String,

    @ColumnInfo(name = "overview")
    var overviews: String,

    @ColumnInfo(name = "imagePath")
    var imagePath: String,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false

)