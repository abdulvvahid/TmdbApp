package com.noor.tmdbapp.data.repository.artist.datasourceImp

import com.noor.tmdbapp.data.db.ArtistDao
import com.noor.tmdbapp.data.model.artist.Artist
import com.noor.tmdbapp.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(
    private val artistDao: ArtistDao
): ArtistLocalDataSource {

    override suspend fun getArtistFromDB(): List<Artist> = artistDao.getArtists()

    override suspend fun saveArtistToDB(artists: List<Artist>){
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAllArtist(){
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }

}