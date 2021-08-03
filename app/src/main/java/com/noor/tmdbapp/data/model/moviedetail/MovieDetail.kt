package com.noor.tmdbapp.data.model.moviedetail

import com.google.gson.annotations.SerializedName

data class MovieDetail(

    @SerializedName("id")
    val id: Int,
    @SerializedName("genres")
    val movieGenres: List<MovieGenre>,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("revenue")
    val revenue: Int,
    @SerializedName("runtime")
    val runtime: Int,
    @SerializedName("vote_average")
    val voteAverage: Double
)