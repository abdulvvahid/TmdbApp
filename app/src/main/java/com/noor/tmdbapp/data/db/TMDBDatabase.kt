package com.noor.tmdbapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.noor.tmdbapp.data.model.artist.Artist
import com.noor.tmdbapp.data.model.movie.Movie
import com.noor.tmdbapp.data.model.tvshow.TvShow

@Database(
    entities = [Movie::class,TvShow::class,Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao

}