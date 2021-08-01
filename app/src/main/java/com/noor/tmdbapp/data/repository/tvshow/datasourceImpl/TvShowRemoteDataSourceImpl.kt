package com.noor.tmdbapp.data.repository.tvshow.datasourceImpl

import com.noor.tmdbapp.data.api.TMDBService
import com.noor.tmdbapp.data.model.tvshow.TvShowList
import com.noor.tmdbapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): TvShowRemoteDataSource {

    override suspend fun getTvShow(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)

}