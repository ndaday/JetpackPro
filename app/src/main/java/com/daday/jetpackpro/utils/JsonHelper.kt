package com.daday.jetpackpro.utils

import android.content.Context
import com.daday.jetpackpro.data.source.remote.response.ContentResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper (private val context: Context){

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovie(): List<ContentResponse> {
        val list = ArrayList<ContentResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("ContentResponses.json").toString())
            val listArray = responseObject.getJSONArray("movie")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("id")
                val title = movie.getString("title")
                val releaseDate = movie.getString("releaseDate")
                val rating = movie.getString("rating")
                val overview = movie.getString("overview")
                val imagePath = movie.getString("imagePath")

                val contentResponse = ContentResponse(id, title, releaseDate, rating, overview, imagePath)
                list.add(contentResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadTvShow(): List<ContentResponse> {
        val list = ArrayList<ContentResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("ContentResponses.json").toString())
            val listArray = responseObject.getJSONArray("tvshow")
            for (i in 0 until listArray.length()) {
                val tvshow = listArray.getJSONObject(i)

                val id = tvshow.getString("id")
                val title = tvshow.getString("title")
                val releaseDate = tvshow.getString("releaseDate")
                val rating = tvshow.getString("rating")
                val overview = tvshow.getString("overview")
                val imagePath = tvshow.getString("imagePath")

                val contentResponse = ContentResponse(id, title, releaseDate, rating, overview, imagePath)
                list.add(contentResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadMovieDetail(movieId: String): List<ContentResponse> {
        val list = ArrayList<ContentResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("ContentResponses.json").toString())
            val listArray = responseObject.getJSONArray("movie")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("id")
                val title = movie.getString("title")
                val releaseDate = movie.getString("releaseDate")
                val rating = movie.getString("rating")
                val overview = movie.getString("overview")
                val imagePath = movie.getString("imagePath")

                val contentResponse = ContentResponse(id, title, releaseDate, rating, overview, imagePath)
                list.add(contentResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadTvShowDetail(tvShowId: String): List<ContentResponse> {
        val list = ArrayList<ContentResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("ContentResponses.json").toString())
            val listArray = responseObject.getJSONArray("tvshow")
            for (i in 0 until listArray.length()) {
                val tvshow = listArray.getJSONObject(i)

                val id = tvshow.getString("id")
                val title = tvshow.getString("title")
                val releaseDate = tvshow.getString("releaseDate")
                val rating = tvshow.getString("rating")
                val overview = tvshow.getString("overview")
                val imagePath = tvshow.getString("imagePath")

                val contentResponse = ContentResponse(id, title, releaseDate, rating, overview, imagePath)
                list.add(contentResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }
}