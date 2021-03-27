package com.deevvdd.domain.repository

import com.deevvdd.domain.model.Movie
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getMovies(): Response<List<Movie>>
}