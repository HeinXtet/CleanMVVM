package com.deevvdd.data.repository

import com.deevvdd.data.api.ApiService
import com.deevvdd.domain.model.Movie
import com.deevvdd.domain.repository.RemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteDataSource {
    override suspend fun getMovies(): Response<List<Movie>> {
        return apiService.getMovies()
    }
}