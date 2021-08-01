package com.noor.tmdbapp.domain.repository

import com.noor.tmdbapp.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?

}