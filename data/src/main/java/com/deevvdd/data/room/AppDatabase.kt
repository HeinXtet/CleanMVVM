package com.deevvdd.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.deevvdd.domain.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
