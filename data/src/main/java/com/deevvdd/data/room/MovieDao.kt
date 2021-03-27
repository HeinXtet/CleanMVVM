package com.deevvdd.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.deevvdd.domain.model.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies : List<Movie>)

    @Query("DELETE FROM popular_movie")
    suspend fun deleteMovies()

    @Query("SELECT * FROM POPULAR_MOVIE")
    suspend fun getAllMovies() : List<Movie>

}