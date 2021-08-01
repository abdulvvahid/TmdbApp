package com.noor.tmdbapp.data.repository.movie.datasource

import com.noor.tmdbapp.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovie(): Response<MovieList>

}