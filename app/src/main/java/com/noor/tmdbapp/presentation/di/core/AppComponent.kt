package com.noor.tmdbapp.presentation.di.core

import com.noor.tmdbapp.presentation.di.artist.ArtistSubComponent
import com.noor.tmdbapp.presentation.di.movie.MovieSubComponent
import com.noor.tmdbapp.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DataBaseModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class
])
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory

}