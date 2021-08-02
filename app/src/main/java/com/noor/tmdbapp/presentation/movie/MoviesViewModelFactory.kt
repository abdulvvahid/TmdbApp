package com.noor.tmdbapp.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.noor.tmdbapp.domain.usecase.GetMoviesUseCase
import com.noor.tmdbapp.domain.usecase.UpdateMoviesUseCase

class MoviesViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(getMoviesUseCase, updateMoviesUseCase) as T
    }
}