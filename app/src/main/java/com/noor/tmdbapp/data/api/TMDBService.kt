package com.noor.tmdbapp.data.api

import com.noor.tmdbapp.data.model.artist.ArtistList
import com.noor.tmdbapp.data.model.moviedetail.MovieDetail
import com.noor.tmdbapp.data.model.movie.MovieList
import com.noor.tmdbapp.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<ArtistList>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id")movie_id:Int,
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<MovieDetail>

}