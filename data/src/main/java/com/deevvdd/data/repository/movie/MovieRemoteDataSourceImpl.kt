package com.deevvdd.data.repository.movie

import com.deevvdd.data.api.ApiService
import com.deevvdd.domain.model.MovieList
import com.deevvdd.domain.repository.movie.MovieRemoteDataSource
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

class MovieRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    @Named("API_KEY") private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return apiService.getMovies(apiKey, 1)
    }
}