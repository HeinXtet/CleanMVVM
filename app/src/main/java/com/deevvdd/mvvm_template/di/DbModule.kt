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
class DbModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext app: Context
    ): RoomDatabase = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "tmdb"
    ).build()


    @Singleton
    @Provides
    fun provideMovieDao(db: AppDatabase): MovieDao = db.movieDao()

}