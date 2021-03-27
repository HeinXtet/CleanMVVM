package com.deevvdd.data.repository.movie

import com.deevvdd.domain.model.Movie
import com.deevvdd.domain.repository.movie.MovieCacheDataSource
import javax.inject.Inject

class MovieCacheDataSourceImpl @Inject constructor() : MovieCacheDataSource {

    private var movies = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movies
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        this.movies.clear()
        this.movies.addAll(movies)
    }

    override suspend fun clearAll() {
        movies.clear()
    }
}