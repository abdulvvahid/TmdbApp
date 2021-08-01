package com.noor.tmdbapp.data.repository.tvshow.datasource

import com.noor.tmdbapp.data.model.tvshow.TvShow

interface TvShowCacheDataSource {

    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)

}