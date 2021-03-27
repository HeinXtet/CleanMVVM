package com.deevvdd.data.repository.movie

import com.deevvdd.data.api.ApiService
import com.deevvdd.domain.model.MovieList
import com.deevvdd.domain.repository.movie.MovieRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return apiService.getMovies()
    }
}