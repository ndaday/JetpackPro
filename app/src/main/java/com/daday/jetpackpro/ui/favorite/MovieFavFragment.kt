package com.daday.jetpackpro.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daday.jetpackpro.R
import com.daday.jetpackpro.databinding.FragmentMovieFavBinding
import com.daday.jetpackpro.ui.ContentViewModel
import com.daday.jetpackpro.ui.movie.MovieAdapter
import com.daday.jetpackpro.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class MovieFavFragment : Fragment() {
    private lateinit var fragmentMovieFavBinding: FragmentMovieFavBinding
    private lateinit var viewModel: ContentViewModel
    private lateinit var adapter: MovieAdapter

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
        itemTouchHelper.attachToRecyclerView(fragmentMovieFavBinding.rvMovieFav)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[ContentViewModel::class.java]

            adapter = MovieAdapter()
            fragmentMovieFavBinding.progressBar.visibility = View.VISIBLE
            viewModel.getMovieFav().observe(viewLifecycleOwner, { movieFav ->
                fragmentMovieFavBinding.progressBar.visibility = View.GONE
                adapter.submitList(movieFav)
            })

            fragmentMovieFavBinding.rvMovieFav.layoutManager = LinearLayoutManager(context)
            fragmentMovieFavBinding.rvMovieFav.setHasFixedSize(true)
            fragmentMovieFavBinding.rvMovieFav.adapter = adapter
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val contentEntity = adapter.getSwipedData(swipedPosition)
                contentEntity?.let { viewModel.setFavoriteMovie(it) }

                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { v ->
                    contentEntity?.let { viewModel.setFavoriteMovie(it) }
                }
                snackbar.show()
            }
        }
    })
}