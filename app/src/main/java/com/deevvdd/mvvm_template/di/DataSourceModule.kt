package com.deevvdd.mvvm_template.di

import com.deevvdd.data.repository.CacheDataSourceImpl
import com.deevvdd.data.repository.LocalDataSourceImpl
import com.deevvdd.data.repository.RemoteDataSourceImpl
import com.deevvdd.domain.repository.CacheDataSource
import com.deevvdd.domain.repository.LocalDataSource
import com.deevvdd.domain.repository.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindMovieRemoteDataSource(
        remoteDataSourceImpl: RemoteDataSourceImpl
    ): RemoteDataSource


    @Binds
    abstract fun bindMovieLocalDataSource(
        localDataSourceImpl: LocalDataSourceImpl
    ): LocalDataSource

    @Binds
    abstract fun bindMovieCacheDataSource(
        cacheDataSourceImpl: CacheDataSourceImpl
    ): CacheDataSource
}