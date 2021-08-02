package com.noor.tmdbapp.presentation.di.core

import com.noor.tmdbapp.data.repository.artist.ArtistRepositoryImpl
import com.noor.tmdbapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.noor.tmdbapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.noor.tmdbapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.noor.tmdbapp.data.repository.movie.MovieRepositoryImpl
import com.noor.tmdbapp.data.repository.movie.datasource.MovieCacheDataSource
import com.noor.tmdbapp.data.repository.movie.datasource.MovieLocalDataSource
import com.noor.tmdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.noor.tmdbapp.data.repository.tvshow.TvShowRepositoryImpl
import com.noor.tmdbapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.noor.tmdbapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.noor.tmdbapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.noor.tmdbapp.domain.repository.ArtistRepository
import com.noor.tmdbapp.domain.repository.MovieRepository
import com.noor.tmdbapp.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistReporsitory(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}