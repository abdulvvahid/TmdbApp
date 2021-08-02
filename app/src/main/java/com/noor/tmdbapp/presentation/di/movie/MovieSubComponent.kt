package com.noor.tmdbapp.presentation.di.movie

import com.noor.tmdbapp.presentation.movie.MoviesFragment
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(moviesFragment: MoviesFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }

}