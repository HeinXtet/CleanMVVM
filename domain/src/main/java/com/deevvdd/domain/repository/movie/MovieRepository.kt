package com.deevvdd.domain.repository.movie

import com.deevvdd.domain.model.Movie
import retrofit2.Response

interface MovieRepository {
    suspend fun fetchMovies(): List<Movie>
    suspend fun updateMovies() : List<Movie>
}