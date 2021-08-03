package com.noor.tmdbapp.domain.usecase

import com.noor.tmdbapp.data.model.moviedetail.MovieDetail
import com.noor.tmdbapp.domain.repository.MovieDetailRepository

class GetMovieDetailUseCase(
    private val movieDetailRepository: MovieDetailRepository
){

    suspend fun execute(): MovieDetail? = movieDetailRepository.getMovieDetail()

}