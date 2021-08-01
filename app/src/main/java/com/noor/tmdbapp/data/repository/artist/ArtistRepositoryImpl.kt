package com.noor.tmdbapp.data.repository.artist

import android.util.Log
import com.noor.tmdbapp.data.model.artist.Artist
import com.noor.tmdbapp.data.model.artist.ArtistList
import com.noor.tmdbapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.noor.tmdbapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.noor.tmdbapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.noor.tmdbapp.domain.repository.ArtistRepository
import retrofit2.Response
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
): ArtistRepository {

    override suspend fun getArtists(): List<Artist> = getArtistFromCache()

    override suspend fun updateArtists(): List<Artist> {
        val newArtistList: List<Artist> = getArtistsFromApi()
        artistLocalDataSource.clearAllArtists()
        artistLocalDataSource.saveArtistToDB(newArtistList)
        artistCacheDataSource.saveArtistToCache(newArtistList)
        return newArtistList
    }

    suspend fun getArtistsFromApi(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response: Response<ArtistList> = artistRemoteDataSource.getArtist()
            val body = response.body()
            if(body != null){
                artistList = body.artists
            }
        }catch (e: Exception){
            Log.i("MyTag", e.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistFromDB()
        }catch (e: Exception){
            Log.i("MyTag", e.message.toString())
        }
        if(artistList.isEmpty()){
            artistList = getArtistsFromApi()
            artistLocalDataSource.clearAllArtists()
            artistLocalDataSource.saveArtistToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try{
            artistList = artistCacheDataSource.getArtistFromCache()
        }catch(e: Exception){
            Log.i("MyTag", e.message.toString())
        }
        if(artistList.isEmpty()){
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)
        }
        return artistList
    }

}