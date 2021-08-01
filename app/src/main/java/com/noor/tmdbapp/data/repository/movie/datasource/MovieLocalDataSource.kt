package com.noor.tmdbapp.data.repository.movie.datasource

import com.noor.tmdbapp.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMovieFromDB(): List<Movie>
    suspend fun saveMovieToDB(movies: List<Movie>)
    suspend fun clearAll()

}