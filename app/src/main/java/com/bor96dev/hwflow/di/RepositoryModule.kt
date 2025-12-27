package com.bor96dev.hwflow.di

import com.bor96dev.hwflow.data.AsiaDataSource
import com.bor96dev.hwflow.data.EuropeDataSource
import com.bor96dev.hwflow.data.NorthAmericaDataSource
import com.bor96dev.hwflow.data.RepositoryImpl
import com.bor96dev.hwflow.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideAsia(): AsiaDataSource = AsiaDataSource()

    @Provides
    fun provideEurope(): EuropeDataSource = EuropeDataSource()

    @Provides
    fun provideAmerica(): NorthAmericaDataSource = NorthAmericaDataSource()

    @Provides
    @Singleton
    fun provideRepository(
        asia: AsiaDataSource,
        europe: EuropeDataSource,
        america: NorthAmericaDataSource
    ): Repository {
        return RepositoryImpl(asia, europe, america)
    }


}