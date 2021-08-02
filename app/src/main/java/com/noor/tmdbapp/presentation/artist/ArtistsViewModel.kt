package com.noor.tmdbapp.presentation.artist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.noor.tmdbapp.data.model.artist.Artist
import com.noor.tmdbapp.domain.usecase.GetArtistsUseCase
import com.noor.tmdbapp.domain.usecase.UpdateArtistUseCase

class ArtistsViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
): ViewModel() {

    fun getArtists(): LiveData<List<Artist>?> = liveData {
        val artistList: List<Artist>? = getArtistsUseCase.execute()
        emit(artistList)
    }

    fun updateArtist() = liveData {
        val artistList: List<Artist>? = getArtistsUseCase.execute()
        emit(artistList)
    }

}