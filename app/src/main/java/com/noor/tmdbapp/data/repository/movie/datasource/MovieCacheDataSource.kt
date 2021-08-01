package com.noor.tmdbapp.data.repository.movie.datasource

import com.noor.tmdbapp.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun saveMoviesToCache(movies: List<Movie>)
    suspend fun getMoviesFromCache(): List<Movie>

}