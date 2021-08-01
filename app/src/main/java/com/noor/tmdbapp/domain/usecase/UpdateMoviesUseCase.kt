package com.noor.tmdbapp.domain.usecase

import com.noor.tmdbapp.data.model.movie.Movie
import com.noor.tmdbapp.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()

}