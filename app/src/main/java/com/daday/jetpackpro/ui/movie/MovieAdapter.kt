package com.daday.jetpackpro.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.daday.jetpackpro.R
import com.daday.jetpackpro.data.source.local.entity.MovieEntity
import com.daday.jetpackpro.databinding.ItemListBinding
import com.daday.jetpackpro.ui.detail.DetailActivity
import com.daday.jetpackpro.utils.Helper.MOVIE

class MovieAdapter : PagedListAdapter<MovieEntity, MovieAdapter.ContentViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContentViewHolder {
        val itemListBinding =
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContentViewHolder(itemListBinding)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null){
            holder.bind(movie)
        }
    }

    fun getSwipedData(swipedPosition: Int): MovieEntity? = getItem(swipedPosition)

    inner class ContentViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataEntity: MovieEntity) {
            with(binding) {
                tvItemTitle.text = dataEntity.title
                tvItemDate.text =
                    itemView.resources.getString(R.string.date, dataEntity.releaseDate)
                tvItemRating.text = dataEntity.rating
                Glide.with(itemView.context)
                    .load(dataEntity.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgPoster)
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DATA, dataEntity.id)
                    intent.putExtra(DetailActivity.EXTRA_TYPE, MOVIE)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}