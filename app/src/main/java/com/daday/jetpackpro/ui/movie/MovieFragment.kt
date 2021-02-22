package com.daday.jetpackpro.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.daday.jetpackpro.databinding.FragmentMovieBinding
import com.daday.jetpackpro.ui.ContentViewModel
import com.daday.jetpackpro.viewmodel.ViewModelFactory
import com.daday.jetpackpro.vo.Status

class MovieFragment : Fragment() {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[ContentViewModel::class.java]

            val contentAdapter = MovieAdapter()
            viewModel.getListMovie().observe(viewLifecycleOwner, { movie ->
                if (movie != null){
                    when(movie.status) {
                        Status.LOADING -> fragmentMovieBinding.progressBar.visibility =
                            View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentMovieBinding.progressBar.visibility = View.GONE
                            contentAdapter.submitList(movie.data)
                        }
                        Status.ERROR -> {
                            fragmentMovieBinding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
                with(fragmentMovieBinding.rvMovies) {
                    this.layoutManager = LinearLayoutManager(context)
                    this.setHasFixedSize(true)
                    this.adapter = contentAdapter
                }
            }
    }
}