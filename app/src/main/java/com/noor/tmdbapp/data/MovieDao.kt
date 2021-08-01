package com.noor.tmdbapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.noor.tmdbapp.data.model.movie.Movie

@Dao
interface MovieDao {

    @Insert( onConflict = OnConflictStrategy.REPLACE )
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM popular_movies")
    suspend fun getMovies(movies: List<Movie>)

}