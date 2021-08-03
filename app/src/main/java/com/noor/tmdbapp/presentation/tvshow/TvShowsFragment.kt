package com.noor.tmdbapp.presentation.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.noor.tmdbapp.R
import com.noor.tmdbapp.databinding.FragmentTvShowsBinding
import com.noor.tmdbapp.presentation.di.Injector

class TvShowsFragment : Fragment() {

    private lateinit var binding: FragmentTvShowsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_tv_shows, container, false)
        // Inflate the layout for this fragment

        (activity?.applicationContext as Injector).createTvShowSubComponent()
            .inject(this)
        activity?.title = "Trending TV Shows"

        return binding.root
    }

}