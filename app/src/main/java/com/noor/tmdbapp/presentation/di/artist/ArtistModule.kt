package com.noor.tmdbapp.presentation.di.artist

import com.noor.tmdbapp.domain.usecase.GetArtistsUseCase
import com.noor.tmdbapp.domain.usecase.UpdateArtistUseCase
import com.noor.tmdbapp.presentation.artist.ArtistsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory (
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ): ArtistsViewModelFactory {
        return ArtistsViewModelFactory(getArtistsUseCase, updateArtistUseCase)
    }

}