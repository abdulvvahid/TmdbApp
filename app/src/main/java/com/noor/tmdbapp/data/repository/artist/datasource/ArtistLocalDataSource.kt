package com.noor.tmdbapp.data.repository.artist.datasource

import com.noor.tmdbapp.data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistFromDB(): List<Artist>
    suspend fun saveArtistToDB(artists: List<Artist>)
    suspend fun clearAllArtists()

}