package com.noor.tmdbapp.data.repository.movie.datasourceImpl

import com.noor.tmdbapp.data.db.MovieDao
import com.noor.tmdbapp.data.model.movie.Movie
import com.noor.tmdbapp.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(
    private val movieDao: MovieDao
): MovieLocalDataSource {

    override suspend fun getMovieFromDB(): List<Movie> = movieDao.getMovies()

    override suspend fun saveMovieToDB(movies: List<Movie>){
        CoroutineScope(Dispatchers.IO).launch{
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAllMovie(){
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }

}