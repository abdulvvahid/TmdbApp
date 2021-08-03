package com.noor.tmdbapp.presentation.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.noor.tmdbapp.data.model.moviedetail.MovieDetail
import com.noor.tmdbapp.domain.usecase.GetMovieDetailUseCase

class MovieDetailViewModel(
    private val getMovieDetailUseCase: GetMovieDetailUseCase
): ViewModel() {

    fun getMovieDetail(): LiveData<MovieDetail?> = liveData {
        val movieList: MovieDetail? = getMovieDetailUseCase.execute()
        emit(movieList)
    }

}