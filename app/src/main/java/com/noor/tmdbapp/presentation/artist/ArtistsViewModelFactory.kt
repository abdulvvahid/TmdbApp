package com.noor.tmdbapp.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.noor.tmdbapp.domain.usecase.GetArtistsUseCase
import com.noor.tmdbapp.domain.usecase.UpdateArtistUseCase

class ArtistsViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArtistsViewModel(getArtistsUseCase, updateArtistUseCase) as T
    }
}