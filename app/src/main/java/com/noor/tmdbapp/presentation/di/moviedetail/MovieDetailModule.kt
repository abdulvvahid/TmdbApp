package com.noor.tmdbapp.presentation.di.moviedetail

import com.noor.tmdbapp.domain.usecase.GetMovieDetailUseCase
import com.noor.tmdbapp.presentation.moviedetail.MovieDetailViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieDetailModule {

    @MovieDetailScope
    @Provides
    fun provideMovieViewModelFactory(
        getMovieDetailUseCase: GetMovieDetailUseCase
    ): MovieDetailViewModelFactory {
        return MovieDetailViewModelFactory(getMovieDetailUseCase)
    }

}