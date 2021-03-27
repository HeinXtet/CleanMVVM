package com.deevvdd.data.api

import com.deevvdd.domain.model.Movie
import com.deevvdd.domain.model.MovieList
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/movie")
    suspend fun getMovies(): Response<MovieList>
}