package com.noor.tmdbapp.presentation.artist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.noor.tmdbapp.R
import com.noor.tmdbapp.data.model.artist.Artist
import com.noor.tmdbapp.databinding.FragmentArtistsBinding
import com.noor.tmdbapp.presentation.di.Injector
import javax.inject.Inject

class ArtistsFragment : Fragment() {

    @Inject
    lateinit var factory: ArtistsViewModelFactory
    private lateinit var binding: FragmentArtistsBinding
    private lateinit var artistsViewModel: ArtistsViewModel
    private lateinit var adapter: ArtistAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_artists, container, false)
        // Inflate the layout for this fragment
        (activity?.applicationContext as Injector).createArtistSubComponent()
            .inject(this)
        activity?.title = "Trending Artists"

        artistsViewModel = ViewModelProvider(this, factory)
            .get(ArtistsViewModel::class.java)

        initRecyclerView()

        binding.artistSwipeRefreshLayout.setOnRefreshListener {
            updateArtist()
            binding.artistSwipeRefreshLayout.isRefreshing = false
        }

        return binding.root
    }

    private fun initRecyclerView() {
        binding.artistRecyclerView.layoutManager =
            GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter
        displayPopularArtists()
    }

    private fun displayPopularArtists() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData: LiveData<List<Artist>?> = artistsViewModel.getArtists()
        responseLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else {
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(context, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun updateArtist() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val response: LiveData<List<Artist>?> = artistsViewModel.updateArtist()
        response.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else {
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(context, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

}