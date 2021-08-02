package com.noor.tmdbapp.presentation.di

import com.noor.tmdbapp.presentation.di.artist.ArtistSubComponent
import com.noor.tmdbapp.presentation.di.movie.MovieSubComponent
import com.noor.tmdbapp.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent

}