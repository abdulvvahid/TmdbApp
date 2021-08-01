package com.noor.tmdbapp.data.repository.tvshow

import android.util.Log
import com.noor.tmdbapp.data.model.tvshow.TvShow
import com.noor.tmdbapp.data.model.tvshow.TvShowList
import com.noor.tmdbapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.noor.tmdbapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.noor.tmdbapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.noor.tmdbapp.domain.repository.TvShowRepository
import retrofit2.Response

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowRepository {

    override suspend fun getTvShows(): List<TvShow> = getTvShowsFromCache()

    override suspend fun updateTvShows(): List<TvShow> {
        val newTvShowList: List<TvShow> = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAllTvShows()
        tvShowLocalDataSource.saveTvShowToDB(newTvShowList)
        tvShowCacheDataSource.saveTvShowsToCache(newTvShowList)
        return newTvShowList
    }

    suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            val response: Response<TvShowList> = tvShowRemoteDataSource.getTvShow()
            val body: TvShowList? = response.body()
            if(body != null){
                tvShowList = body.tvShows
            }
        }catch (e: Exception){
            Log.i("MyTag", e.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getDataFromDB()
        }catch (e: Exception){
            Log.i("MyTag", e.message.toString())
        }
        if (tvShowList.isEmpty()){
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.clearAllTvShows()
            tvShowLocalDataSource.saveTvShowToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        }catch (e: Exception){
            Log.i("MyTag", e.message.toString())
        }
        if(tvShowList.isEmpty()){
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }

}