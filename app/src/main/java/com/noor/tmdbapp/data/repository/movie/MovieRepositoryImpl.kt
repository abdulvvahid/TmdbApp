package com.noor.tmdbapp.data.repository.movie

import android.util.Log
import com.noor.tmdbapp.data.model.movie.Movie
import com.noor.tmdbapp.data.model.movie.MovieList
import com.noor.tmdbapp.data.repository.movie.datasource.MovieCacheDataSource
import com.noor.tmdbapp.data.repository.movie.datasource.MovieLocalDataSource
import com.noor.tmdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.noor.tmdbapp.domain.repository.MovieRepository
import retrofit2.Response
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {

    override suspend fun getMovies(): List<Movie> = getMovieFromCache()

    override suspend fun updateMovies(): List<Movie> {
        val newListOfMovies: List<Movie> = getMoviesFromAPI()
        movieLocalDataSource.clearAllMovies()
        movieLocalDataSource.saveMovieToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            val response: Response<MovieList> = movieRemoteDataSource.getMovie()
            val body: MovieList? = response.body()
            if(body != null){
                movieList = body.movies
            }
        }catch (e: Exception){
            Log.i("Tag", e.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMovieFromDB()
        }catch (e: Exception){
            Log.i("Tag",e.message.toString())
        }
        if(movieList.isEmpty()){
            movieList = getMoviesFromAPI()
            movieLocalDataSource.clearAllMovies()
            movieLocalDataSource.saveMovieToDB(movieList)
        }
        return movieList
    }

    suspend fun getMovieFromCache(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (e: Exception){
            Log.i("Tag",e.message.toString())
        }
        if(movieList.isEmpty()){
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }

}