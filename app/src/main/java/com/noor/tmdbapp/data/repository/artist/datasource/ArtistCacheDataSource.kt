package com.noor.tmdbapp.data.repository.artist.datasource

import com.noor.tmdbapp.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun getArtistFromCache(): List<Artist>
    suspend fun saveArtistToCache(artists: List<Artist>)

}