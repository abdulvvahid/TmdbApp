package com.noor.tmdbapp.data.repository.artist.datasource

import com.noor.tmdbapp.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtist(): Response<ArtistList>

}