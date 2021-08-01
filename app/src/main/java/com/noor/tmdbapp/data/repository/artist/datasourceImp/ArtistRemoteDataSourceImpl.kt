package com.noor.tmdbapp.data.repository.artist.datasourceImp

import com.noor.tmdbapp.data.api.TMDBService
import com.noor.tmdbapp.data.model.artist.ArtistList
import com.noor.tmdbapp.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): ArtistRemoteDataSource {

    override suspend fun getArtist(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)

}