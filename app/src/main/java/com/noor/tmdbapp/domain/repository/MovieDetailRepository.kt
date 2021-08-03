package com.noor.tmdbapp.domain.repository

import com.noor.tmdbapp.data.model.moviedetail.MovieDetail

interface MovieDetailRepository {

    suspend fun getMovieDetail(): MovieDetail?

}