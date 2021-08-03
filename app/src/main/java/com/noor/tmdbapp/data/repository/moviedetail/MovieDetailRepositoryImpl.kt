package com.noor.tmdbapp.data.repository.moviedetail

import android.util.Log
import com.noor.tmdbapp.data.model.moviedetail.MovieDetail
import com.noor.tmdbapp.data.repository.moviedetail.datasource.MovieDetailRemoteDataSource
import com.noor.tmdbapp.domain.repository.MovieDetailRepository

class MovieDetailRepositoryImpl(
    private val movieDetailRemoteDataSource: MovieDetailRemoteDataSource
): MovieDetailRepository {
    override suspend fun getMovieDetail(): MovieDetail{
        lateinit var movieDetails: MovieDetail
        try {
            val response = movieDetailRemoteDataSource.getMovieDetailFromAPI()
            val body = response.body()
            if (body != null){
                movieDetails = body
                Log.i("Basardım", movieDetails.toString())
            }
        }catch (e: Exception){
            Log.i("Basaramadım", "Neyi başaramadın + ${e.message.toString()}")
        }
        return movieDetails
    }
}