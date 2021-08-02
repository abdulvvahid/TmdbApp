package com.noor.tmdbapp.presentation.di.core

import com.noor.tmdbapp.data.db.ArtistDao
import com.noor.tmdbapp.data.db.MovieDao
import com.noor.tmdbapp.data.db.TvShowDao
import com.noor.tmdbapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.noor.tmdbapp.data.repository.artist.datasourceImp.ArtistLocalDataSourceImpl
import com.noor.tmdbapp.data.repository.movie.datasource.MovieLocalDataSource
import com.noor.tmdbapp.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.noor.tmdbapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.noor.tmdbapp.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

}