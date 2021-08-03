package com.noor.tmdbapp.presentation.di.moviedetail

import com.noor.tmdbapp.presentation.moviedetail.MovieDetailFragment
import dagger.Subcomponent

@MovieDetailScope
@Subcomponent(modules = [MovieDetailModule::class])
interface MovieDetailSubComponent {

    fun inject(movieDetailFragment: MovieDetailFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieDetailSubComponent
    }

}