package com.deevvdd.domain.repository.movie

import com.deevvdd.domain.model.Movie
import com.deevvdd.domain.model.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}