package com.deevvdd.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


data class MovieList(
    val results: List<Movie>
)


@Entity(tableName = "popular_movie")
data class Movie(
    @PrimaryKey
    val id: String,
    val name: String
)