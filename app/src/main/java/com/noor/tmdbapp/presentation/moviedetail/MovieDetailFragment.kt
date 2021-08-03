package com.noor.tmdbapp.presentation.moviedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.noor.tmdbapp.R
import com.noor.tmdbapp.databinding.FragmentMovieDetailBinding
import com.noor.tmdbapp.presentation.di.Injector
import javax.inject.Inject

class MovieDetailFragment : Fragment() {

    @Inject
    lateinit var factory: MovieDetailViewModelFactory
    private lateinit var binding: FragmentMovieDetailBinding
    private lateinit var movieDetailViewModel: MovieDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_movie_detail, container, false)
        // Inflate the layout for this fragment

        (activity?.applicationContext as Injector).createMovieDetailSubComponent()
            .inject(this)
        activity?.title = "Movie Details"

        return binding.root
    }

}