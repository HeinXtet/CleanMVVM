package com.deevvdd.domain.repository

import com.deevvdd.domain.model.Movie
import retrofit2.Response

interface MovieRepository {
    suspend fun fetchMovie(): Response<List<Movie>>
}