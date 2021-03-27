package com.deevvdd.data.repository

import com.deevvdd.domain.model.Movie
import com.deevvdd.domain.repository.CacheDataSource
import com.deevvdd.domain.repository.LocalDataSource
import com.deevvdd.domain.repository.MovieRepository
import com.deevvdd.domain.repository.RemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource:RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val cacheDataSource: CacheDataSource,
) : MovieRepository {
    override suspend fun fetchMovie(): Response<List<Movie>> {
        return remoteDataSource.getMovies()
    }
}