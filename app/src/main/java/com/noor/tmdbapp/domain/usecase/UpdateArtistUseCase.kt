package com.noor.tmdbapp.domain.usecase

import com.noor.tmdbapp.data.model.artist.Artist
import com.noor.tmdbapp.domain.repository.ArtistRepository

class UpdateArtistUseCase (private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()

}