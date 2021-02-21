package com.daday.jetpackpro.ui.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.daday.jetpackpro.ui.ContentViewModel
import com.daday.jetpackpro.databinding.FragmentTvShowBinding
import com.daday.jetpackpro.viewmodel.ViewModelFactory
import com.daday.jetpackpro.vo.Status

class TvShowFragment : Fragment() {

    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[ContentViewModel::class.java]

            val contentAdapter = TvShowAdapter()
            viewModel.getListTvShow().observe(viewLifecycleOwner, {tvShow ->
                if (tvShow != null){
                    when(tvShow.status) {
                        Status.LOADING -> fragmentTvShowBinding.progressBar.visibility =
                            View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentTvShowBinding.progressBar.visibility = View.GONE
                            contentAdapter.setContent(tvShow.data)
                            contentAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            fragmentTvShowBinding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
            with(fragmentTvShowBinding.rvTvshow) {
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = contentAdapter
            }
        }
    }
}