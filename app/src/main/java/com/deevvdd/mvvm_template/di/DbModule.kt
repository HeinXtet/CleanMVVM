package com.deevvdd.mvvm_template.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.deevvdd.data.room.AppDatabase
import com.deevvdd.data.room.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "tmdb_db"
    ).build() // The reason we can construct a database for the repo

    @Singleton
    @Provides
    fun provideMovieDao(db: AppDatabase) =
        db.movieDao() // The reason we can implement a Dao for the database
}