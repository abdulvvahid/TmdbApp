package com.noor.tmdbapp.presentation.di.core

import com.noor.tmdbapp.data.api.TMDBService
import com.noor.tmdbapp.data.db.TMDBDatabase
import com.noor.tmdbapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.noor.tmdbapp.data.repository.artist.datasourceImp.ArtistRemoteDataSourceImpl
import com.noor.tmdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.noor.tmdbapp.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.noor.tmdbapp.data.repository.moviedetail.datasource.MovieDetailRemoteDataSource
import com.noor.tmdbapp.data.repository.moviedetail.datasourceImpl.MovieDetailRemoteDataSourceImpl
import com.noor.tmdbapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.noor.tmdbapp.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String, private val movieId: Int) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun providTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideMovieDetailRemoteDataSource(tmdbService: TMDBService): MovieDetailRemoteDataSource {
        return MovieDetailRemoteDataSourceImpl(tmdbService, apiKey, movieId)
    }

}