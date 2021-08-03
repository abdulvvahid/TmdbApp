package com.noor.tmdbapp.presentation.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.noor.tmdbapp.R
import com.noor.tmdbapp.data.model.tvshow.TvShow
import com.noor.tmdbapp.databinding.FragmentTvShowsBinding
import com.noor.tmdbapp.presentation.di.Injector
import javax.inject.Inject

class TvShowsFragment : Fragment() {

    @Inject
    lateinit var factory: TvShowsViewModelFactory
    private lateinit var binding: FragmentTvShowsBinding
    private lateinit var tvShowsViewModel: TvShowsViewModel
    private lateinit var adapter: TvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_tv_shows, container, false)
        // Inflate the layout for this fragment

        (activity?.applicationContext as Injector).createTvShowSubComponent()
            .inject(this)
        activity?.title = "Trending TV Shows"

        tvShowsViewModel = ViewModelProvider(this, factory)
            .get(TvShowsViewModel::class.java)

        initRecyclerView()

        binding.tvShowSwipeRefreshLayout.setOnRefreshListener {
            updateTvShows()
            binding.tvShowSwipeRefreshLayout.isRefreshing = false
        }

        return binding.root
    }

    private fun initRecyclerView() {
        binding.tvShowRecyclerView.layoutManager =
            GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        adapter = TvShowAdapter()
        binding.tvShowRecyclerView.adapter = adapter
        displayPopulatTvShows()
    }

    private fun displayPopulatTvShows() {
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val responseLiveData: LiveData<List<TvShow>?> = tvShowsViewModel.getTvShows()
        responseLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            } else {
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(context, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun updateTvShows() {
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val response: LiveData<List<TvShow>?> = tvShowsViewModel.updateTvShows()
        response.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            } else {
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(context, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

}