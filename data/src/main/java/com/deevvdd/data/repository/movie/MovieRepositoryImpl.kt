package com.deevvdd.data.repository.movie

import com.deevvdd.domain.model.Movie
import com.deevvdd.domain.repository.movie.MovieCacheDataSource
import com.deevvdd.domain.repository.movie.MovieLocalDataSource
import com.deevvdd.domain.repository.movie.MovieRemoteDataSource
import com.deevvdd.domain.repository.movie.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource,
    private val localDataSource: MovieLocalDataSource,
    private val cacheDataSource: MovieCacheDataSource,
) : MovieRepository {
    override suspend fun fetchMovies(): List<Movie> = getMoviesFromCache()

    override suspend fun updateMovies(): List<Movie> {
        val newListMovies = getMoviesFromAPI()
        localDataSource.clearAll()
        cacheDataSource.clearAll()
        localDataSource.saveMoviesToDB(newListMovies)
        cacheDataSource.saveMoviesToCache(newListMovies)
        return newListMovies
    }


    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = remoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.results
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return movieList
    }


    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = localDataSource.getMoviesFromDB()
            if (!movieList.isEmpty()) {
                return movieList
            } else {
                movieList = getMoviesFromAPI()
                localDataSource.saveMoviesToDB(movieList)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = cacheDataSource.getMoviesFromCache()
            if (!movieList.isEmpty()) {
                return movieList
            } else {
                movieList = getMoviesFromDB()
                cacheDataSource.saveMoviesToCache(movieList)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return movieList
    }

}