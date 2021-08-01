package com.noor.tmdbapp.domain.repository

import com.noor.tmdbapp.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?

}