package com.noor.tmdbapp.domain.usecase

import com.noor.tmdbapp.data.model.tvshow.TvShow
import com.noor.tmdbapp.domain.repository.TvShowRepository

class UpdateTvShowsUseCase (private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()

}