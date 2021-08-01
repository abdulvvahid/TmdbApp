package com.noor.tmdbapp.data.repository.movie.datasourceImpl

import com.noor.tmdbapp.data.api.TMDBService
import com.noor.tmdbapp.data.model.movie.MovieList
import com.noor.tmdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): MovieRemoteDataSource {

    override suspend fun getMovie(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}