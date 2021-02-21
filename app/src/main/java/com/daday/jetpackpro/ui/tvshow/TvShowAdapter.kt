package com.daday.jetpackpro.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.daday.jetpackpro.R
import com.daday.jetpackpro.data.source.local.entity.TvShowEntity
import com.daday.jetpackpro.databinding.ItemListBinding
import com.daday.jetpackpro.ui.detail.DetailActivity
import com.daday.jetpackpro.utils.Helper.TVSHOW

class TvShowAdapter :
    RecyclerView.Adapter<TvShowAdapter.ContentViewHolder>() {

    private val listContent = ArrayList<TvShowEntity>()

    fun setContent(data: List<TvShowEntity>?) {
        if (data.isNullOrEmpty()) return
        listContent.clear()
        listContent.addAll(data)
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
        holder.bind(listContent[position])
    }

    override fun getItemCount(): Int = listContent.size

    inner class ContentViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dataEntity: TvShowEntity) {
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
                    intent.putExtra(DetailActivity.EXTRA_TYPE, TVSHOW)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}