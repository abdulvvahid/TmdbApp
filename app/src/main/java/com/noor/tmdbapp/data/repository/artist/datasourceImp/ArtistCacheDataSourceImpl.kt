package com.noor.tmdbapp.data.repository.artist.datasourceImp

import com.noor.tmdbapp.data.model.artist.Artist
import com.noor.tmdbapp.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {

    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistFromCache(): List<Artist> = artistList

    override suspend fun saveArtistToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}