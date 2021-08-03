package com.noor.tmdbapp.presentation.moviedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.noor.tmdbapp.domain.usecase.GetMovieDetailUseCase

class MovieDetailViewModelFactory(
    private val getMovieDetailUseCase: GetMovieDetailUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieDetailViewModel(getMovieDetailUseCase) as T
    }

}