package com.noor.tmdbapp.data.repository.tvshow.datasource

import com.noor.tmdbapp.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShow(): Response<TvShowList>

}