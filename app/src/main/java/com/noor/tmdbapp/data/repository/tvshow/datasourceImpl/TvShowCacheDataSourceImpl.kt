package com.noor.tmdbapp.data.repository.tvshow.datasourceImpl

import com.noor.tmdbapp.data.model.tvshow.TvShow
import com.noor.tmdbapp.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {

    private var tvShowlist = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> = tvShowlist

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowlist.clear()
        tvShowlist = ArrayList(tvShows)
    }
}