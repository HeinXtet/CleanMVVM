package com.deevvdd.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class MovieList(
    @SerializedName("results")
    val results: List<Movie>
)

@Entity(tableName = "popular_movies")
data class Movie(
    @SerializedName("id")
    @PrimaryKey
    var id: Int,
    @SerializedName("original_title")
    var originalTitle: String,
    @SerializedName("overview")
    var overview: String,
    @SerializedName("release_date")
    var releaseDate: String,
    @SerializedName("poster_path")
    var posterPath: String,
    @SerializedName("backdrop_path")
    var backdropPath: String,
    @SerializedName("title")
    var title: String

)