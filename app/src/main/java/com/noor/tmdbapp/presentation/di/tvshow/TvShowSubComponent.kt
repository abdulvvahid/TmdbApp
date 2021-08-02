package com.noor.tmdbapp.presentation.di.tvshow

import com.noor.tmdbapp.presentation.tvshow.TvShowsFragment
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowsFragment: TvShowsFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }
}