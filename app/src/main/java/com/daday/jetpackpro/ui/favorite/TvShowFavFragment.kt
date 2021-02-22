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
import com.daday.jetpackpro.databinding.FragmentTvShowFavBinding
import com.daday.jetpackpro.ui.ContentViewModel
import com.daday.jetpackpro.ui.tvshow.TvShowAdapter
import com.daday.jetpackpro.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class TvShowFavFragment : Fragment() {

  private lateinit var fragmentTvShowFavBinding: FragmentTvShowFavBinding

    private lateinit var viewModel: ContentViewModel
    private lateinit var adapter: TvShowAdapter

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
        itemTouchHelper.attachToRecyclerView(fragmentTvShowFavBinding.rvTvshowFav)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[ContentViewModel::class.java]

            adapter = TvShowAdapter()
            fragmentTvShowFavBinding.progressBar.visibility = View.VISIBLE
            viewModel.getTvShowFav().observe(viewLifecycleOwner, { tvShowFav ->
                fragmentTvShowFavBinding.progressBar.visibility = View.GONE
                adapter.submitList(tvShowFav)
            })

            fragmentTvShowFavBinding.rvTvshowFav.layoutManager = LinearLayoutManager(context)
            fragmentTvShowFavBinding.rvTvshowFav.setHasFixedSize(true)
            fragmentTvShowFavBinding.rvTvshowFav.adapter = adapter
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
                contentEntity?.let { viewModel.setFavoriteTvShow(it) }

                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { v ->
                    contentEntity?.let { viewModel.setFavoriteTvShow(it) }
                }
                snackbar.show()
            }
        }
    })
}