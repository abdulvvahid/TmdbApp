package com.noor.tmdbapp.domain.usecase

import com.noor.tmdbapp.data.model.artist.Artist
import com.noor.tmdbapp.domain.repository.ArtistRepository

class GetArtistsUseCase(private val getArtistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = getArtistRepository.getArtists()

}