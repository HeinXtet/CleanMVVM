package com.deevvdd.data.repository.movie

import com.deevvdd.data.room.MovieDao
import com.deevvdd.domain.model.Movie
import com.deevvdd.domain.repository.movie.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(
    private val movieDio: MovieDao
) : MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> = movieDio.getAllMovies()

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDio.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDio.deleteMovies()
        }
    }
}