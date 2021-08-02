package com.noor.tmdbapp.presentation.artist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.noor.tmdbapp.R
import com.noor.tmdbapp.databinding.FragmentArtistsBinding

class ArtistsFragment : Fragment() {

    private lateinit var binding: FragmentArtistsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_artists, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

}