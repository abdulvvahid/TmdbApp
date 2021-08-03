package com.noor.tmdbapp.presentation

import android.app.Application
import com.noor.tmdbapp.BuildConfig
import com.noor.tmdbapp.presentation.di.Injector
import com.noor.tmdbapp.presentation.di.artist.ArtistSubComponent
import com.noor.tmdbapp.presentation.di.core.*
import com.noor.tmdbapp.presentation.di.movie.MovieSubComponent
import com.noor.tmdbapp.presentation.di.moviedetail.MovieDetailSubComponent
import com.noor.tmdbapp.presentation.di.tvshow.TvShowSubComponent

class App: Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY, BuildConfig.MOVIE_ID))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

    override fun createMovieDetailSubComponent(): MovieDetailSubComponent {
        return appComponent.movieDetailSubComponent().create()
    }


}