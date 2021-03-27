package com.deevvdd.data.room

import androidx.room.Dao

@Dao
interface MovieDao {
    suspend fun saveMovies(movies: List<Any>) {}
}