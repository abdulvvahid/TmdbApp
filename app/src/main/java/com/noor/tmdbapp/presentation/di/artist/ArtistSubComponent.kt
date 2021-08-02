package com.noor.tmdbapp.presentation.di.artist

import com.noor.tmdbapp.presentation.artist.ArtistsFragment
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    fun inject(artistsFragment: ArtistsFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponent
    }

}