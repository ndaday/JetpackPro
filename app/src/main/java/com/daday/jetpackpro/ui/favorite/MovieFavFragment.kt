package com.daday.jetpackpro.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.daday.jetpackpro.R
import com.daday.jetpackpro.databinding.EmptyStateBinding
import com.daday.jetpackpro.databinding.FragmentMovieBinding
import com.daday.jetpackpro.databinding.FragmentMovieFavBinding
import com.daday.jetpackpro.ui.ContentViewModel
import com.daday.jetpackpro.ui.movie.MovieAdapter
import com.daday.jetpackpro.viewmodel.ViewModelFactory
import com.daday.jetpackpro.vo.Status

class MovieFavFragment : Fragment() {
    private lateinit var fragmentMovieFavBinding: FragmentMovieFavBinding
    private lateinit var emptyStateBinding: EmptyStateBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMovieFavBinding = FragmentMovieFavBinding.inflate(layoutInflater, container, false)
        return fragmentMovieFavBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[ContentViewModel::class.java]

            val contentAdapter = MovieAdapter()
            fragmentMovieFavBinding.progressBar.visibility = View.VISIBLE
            viewModel.getMovieFav().observe(viewLifecycleOwner, { movieFav ->
                fragmentMovieFavBinding.progressBar.visibility = View.GONE
                contentAdapter.setContent(movieFav)
                contentAdapter.notifyDataSetChanged()
            })

            fragmentMovieFavBinding.rvMovieFav.layoutManager = LinearLayoutManager(context)
            fragmentMovieFavBinding.rvMovieFav.setHasFixedSize(true)
            fragmentMovieFavBinding.rvMovieFav.adapter = contentAdapter
        }
    }

}