package com.daday.jetpackpro.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.daday.jetpackpro.R
import com.daday.jetpackpro.databinding.FragmentMovieFavBinding
import com.daday.jetpackpro.databinding.FragmentTvShowFavBinding
import com.daday.jetpackpro.ui.ContentViewModel
import com.daday.jetpackpro.ui.movie.MovieAdapter
import com.daday.jetpackpro.ui.tvshow.TvShowAdapter
import com.daday.jetpackpro.viewmodel.ViewModelFactory

class TvShowFavFragment : Fragment() {
  private lateinit var fragmentTvShowFavBinding: FragmentTvShowFavBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowFavBinding = FragmentTvShowFavBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowFavBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[ContentViewModel::class.java]

            val contentAdapter = TvShowAdapter()
            fragmentTvShowFavBinding.progressBar.visibility = View.VISIBLE
            viewModel.getTvShowFav().observe(viewLifecycleOwner, { tvShowFav ->
                fragmentTvShowFavBinding.progressBar.visibility = View.GONE
                contentAdapter.setContent(tvShowFav)
                contentAdapter.notifyDataSetChanged()
            })

            fragmentTvShowFavBinding.rvTvshowFav.layoutManager = LinearLayoutManager(context)
            fragmentTvShowFavBinding.rvTvshowFav.setHasFixedSize(true)
            fragmentTvShowFavBinding.rvTvshowFav.adapter = contentAdapter
        }
    }
}