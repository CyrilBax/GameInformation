package com.example.business.domain.profiles

import com.example.business.data.profiles.RawgApiKeyDataSourceModule
import com.example.business.domain.repositories.RawgRepository
import com.example.business.domain.repositories.implementations.RawgRepositoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [RawgApiKeyDataSourceModule::class])
abstract class RawgApiKeyRepositoryModule {

    @Binds
    abstract fun bindRawgRepository(repositoryImpl: RawgRepositoryImpl): RawgRepository
}