package com.noor.tmdbapp.data.repository.moviedetail.datasourceImpl

import com.noor.tmdbapp.data.api.TMDBService
import com.noor.tmdbapp.data.model.moviedetail.MovieDetail
import com.noor.tmdbapp.data.repository.moviedetail.datasource.MovieDetailRemoteDataSource
import retrofit2.Response

class MovieDetailRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String,
    private val movieId: Int
): MovieDetailRemoteDataSource{

    override suspend fun getMovieDetailFromAPI(): Response<MovieDetail> = tmdbService.getMovieDetail(movieId,apiKey)
}