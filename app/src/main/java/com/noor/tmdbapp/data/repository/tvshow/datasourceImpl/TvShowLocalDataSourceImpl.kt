package com.noor.tmdbapp.data.repository.tvshow.datasourceImpl

import com.noor.tmdbapp.data.db.TvShowDao
import com.noor.tmdbapp.data.model.tvshow.TvShow
import com.noor.tmdbapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(
    private val tvShowDao: TvShowDao
): TvShowLocalDataSource {

    override suspend fun getDataFromDB(): List<TvShow> = tvShowDao.getTvShows()

    override suspend fun saveTvShowToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAllTvShows() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}