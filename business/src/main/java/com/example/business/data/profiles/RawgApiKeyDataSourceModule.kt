package com.example.business.data.profiles

import com.example.business.data.datasources.RawgApiKeyDataSource
import com.example.business.data.datasources.implementations.RawgApiKeyDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RawgApiKeyDataSourceModule {

    @Binds
    abstract fun bindRawgApiKeyDataSource(dataSourceImpl: RawgApiKeyDataSourceImpl): RawgApiKeyDataSource
}