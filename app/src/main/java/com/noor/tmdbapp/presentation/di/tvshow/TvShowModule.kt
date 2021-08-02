package com.noor.tmdbapp.presentation.di.tvshow

import com.noor.tmdbapp.domain.usecase.GetTvShowsUseCase
import com.noor.tmdbapp.domain.usecase.UpdateTvShowsUseCase
import com.noor.tmdbapp.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }

}