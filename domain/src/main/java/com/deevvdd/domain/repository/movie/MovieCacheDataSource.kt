package com.deevvdd.domain.repository.movie

import com.deevvdd.domain.model.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
    suspend fun clearAll()

}