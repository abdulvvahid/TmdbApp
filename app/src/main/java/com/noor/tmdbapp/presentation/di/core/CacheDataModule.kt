package com.noor.tmdbapp.presentation.di.core

import com.noor.tmdbapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.noor.tmdbapp.data.repository.artist.datasourceImp.ArtistCacheDataSourceImpl
import com.noor.tmdbapp.data.repository.movie.datasource.MovieCacheDataSource
import com.noor.tmdbapp.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.noor.tmdbapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.noor.tmdbapp.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

}