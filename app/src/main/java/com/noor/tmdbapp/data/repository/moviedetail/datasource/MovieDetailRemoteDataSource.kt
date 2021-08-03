package com.noor.tmdbapp.data.repository.moviedetail.datasource

import com.noor.tmdbapp.data.model.moviedetail.MovieDetail
import retrofit2.Response

interface MovieDetailRemoteDataSource {

    suspend fun getMovieDetailFromAPI(): Response<MovieDetail>

}