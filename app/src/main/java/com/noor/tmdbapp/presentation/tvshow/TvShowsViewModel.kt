package com.noor.tmdbapp.presentation.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.noor.tmdbapp.data.model.tvshow.TvShow
import com.noor.tmdbapp.domain.usecase.GetTvShowsUseCase
import com.noor.tmdbapp.domain.usecase.UpdateTvShowsUseCase

class TvShowsViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModel() {

    fun getTvShows(): LiveData<List<TvShow>?> = liveData {
        val tvShowList: List<TvShow>? = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData {
        val tvShowList: List<TvShow>? = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }

}