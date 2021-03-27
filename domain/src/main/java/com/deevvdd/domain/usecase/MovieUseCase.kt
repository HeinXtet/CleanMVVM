package com.deevvdd.domain.usecase

import com.deevvdd.domain.repository.MovieRepository
import javax.inject.Inject

class MovieUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    suspend fun getMovies() = movieRepository.fetchMovie()
}