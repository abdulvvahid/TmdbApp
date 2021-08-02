package com.noor.tmdbapp.presentation.di.movie

import com.noor.tmdbapp.domain.usecase.GetMoviesUseCase
import com.noor.tmdbapp.domain.usecase.UpdateMoviesUseCase
import com.noor.tmdbapp.presentation.movie.MoviesViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MoviesViewModelFactory {
        return MoviesViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}