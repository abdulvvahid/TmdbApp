package com.noor.tmdbapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.noor.tmdbapp.data.model.artist.Artist

@Dao
interface ArtistDao {

    @Insert( onConflict = OnConflictStrategy.REPLACE )
    suspend fun saveArtists(artists: List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteAllArtists()

    @Query( "SELECT * FROM popular_artists")
    suspend fun getArtists(artists: List<Artist>)

}