package com.noor.tmdbapp.domain.repository

import com.noor.tmdbapp.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?

}