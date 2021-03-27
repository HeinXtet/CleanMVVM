package com.deevvdd.mvvm_template.di

import com.deevvdd.data.repository.movie.MovieCacheDataSourceImpl
import com.deevvdd.data.repository.movie.MovieLocalDataSourceImpl
import com.deevvdd.data.repository.movie.MovieRemoteDataSourceImpl
import com.deevvdd.domain.repository.movie.MovieCacheDataSource
import com.deevvdd.domain.repository.movie.MovieLocalDataSource
import com.deevvdd.domain.repository.movie.MovieRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindMovieRemoteDataSource(
        remoteDataSourceImpl: MovieRemoteDataSourceImpl
    ): MovieRemoteDataSource


    @Binds
    abstract fun bindMovieLocalDataSource(
        localDataSourceImpl: MovieLocalDataSourceImpl
    ): MovieLocalDataSource

    @Binds
    abstract fun bindMovieCacheDataSource(
        cacheDataSourceImpl: MovieCacheDataSourceImpl
    ): MovieCacheDataSource
}