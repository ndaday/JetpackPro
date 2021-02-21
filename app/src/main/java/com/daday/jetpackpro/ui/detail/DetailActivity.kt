package com.daday.jetpackpro.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.daday.jetpackpro.R
import com.daday.jetpackpro.data.source.local.entity.MovieEntity
import com.daday.jetpackpro.data.source.local.entity.TvShowEntity
import com.daday.jetpackpro.databinding.ActivityDetailBinding
import com.daday.jetpackpro.utils.Helper.MOVIE
import com.daday.jetpackpro.utils.Helper.TVSHOW
import com.daday.jetpackpro.viewmodel.ViewModelFactory
import com.daday.jetpackpro.vo.Status

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var detailBinding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel
    private var menu: Menu? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        supportActionBar?.title = getString(R.string.detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val id = intent.getStringExtra(EXTRA_DATA)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if(type.equals(MOVIE, true)){
            detailBinding.progressBar.visibility = View.VISIBLE
            id?.let { viewModel.setMovieId(it) }
            viewModel.contentMovie.observe(this, { movie ->
                if (movie != null){
                    when(movie.status){
                        Status.LOADING -> detailBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> if (movie.data != null) {
                            detailBinding.progressBar.visibility = View.GONE
                            populateData(movie.data, null)
                        }
                        Status.ERROR -> {
                            detailBinding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

        } else if (type.equals(TVSHOW, true)){
            detailBinding.progressBar.visibility = View.VISIBLE
            id?.let { viewModel.setTvShowId(it) }
            viewModel.contentTvShow.observe(this, { tvShow ->
                if (tvShow != null){
                    when(tvShow.status){
                        Status.LOADING -> detailBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> if (tvShow.data != null) {
                            detailBinding.progressBar.visibility = View.GONE
                            populateData(null, tvShow.data)
                        }
                        Status.ERROR -> {
                            detailBinding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }
    }

    private fun populateData(movie: MovieEntity?, tvShow: TvShowEntity? ) {
        detailBinding.tvItemTitle.text = movie?.title ?: tvShow?.title
        detailBinding.tvItemDate.text = movie?.releaseDate ?: tvShow?.releaseDate
        detailBinding.tvItemRating  .text = movie?.rating ?: tvShow?.rating
        detailBinding.tvItemOverview.text = movie?.overviews ?: tvShow?.overviews
        Glide.with(this)
            .load(movie?.imagePath ?: tvShow?.imagePath)
            .transform(RoundedCorners(20))
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
            .error(R.drawable.ic_error)
            .into(detailBinding.imagePoster)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu =  menu
        val type = intent.getStringExtra(EXTRA_TYPE)
        if (type.equals(MOVIE, true)){
            viewModel.contentMovie.observe(this, { movieFav ->
                if (movieFav != null){
                    when(movieFav.status){
                        Status.LOADING -> detailBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> if(movieFav.data != null){
                            detailBinding.progressBar.visibility = View.GONE
                            val state = movieFav.data.favorite
                            setFavoriteState(state)
                        }
                        Status.ERROR -> {
                            detailBinding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        } else if (type.equals(TVSHOW, true)){
            viewModel.contentTvShow.observe(this, { tvShowFav ->
                if (tvShowFav != null){
                    when(tvShowFav.status){
                        Status.LOADING -> detailBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> if(tvShowFav.data != null){
                            detailBinding.progressBar.visibility = View.GONE
                            val state = tvShowFav.data.favorite
                            setFavoriteState(state)
                        }
                        Status.ERROR -> {
                            detailBinding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val type = intent.getStringExtra(EXTRA_TYPE)
        if (type.equals(MOVIE, true)){
            if (item.itemId == R.id.action_favorite){
                viewModel.setBookmarkMovie()
                return true
            }
        } else if (type.equals(TVSHOW, true)){
            if (item.itemId == R.id.action_favorite){
                viewModel.setBookmarkTvShow()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_border)
        }
    }
}