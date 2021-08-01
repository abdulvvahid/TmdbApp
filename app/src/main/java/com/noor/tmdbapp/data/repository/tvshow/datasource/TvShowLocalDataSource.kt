package com.noor.tmdbapp.data.repository.tvshow.datasource

import com.noor.tmdbapp.data.model.tvshow.TvShow

interface TvShowLocalDataSource {

    suspend fun getDataFromDB(): List<TvShow>
    suspend fun saveTvShowToDB(tvShows: List<TvShow>)
    suspend fun clearAllTvShows()

}