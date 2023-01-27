package com.example.gameinformation.domain.repositories.profiles

import com.example.gameinformation.domain.repositories.RemoteConfigRepository
import com.example.gameinformation.domain.repositories.implementations.RemoteConfigRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RemoteConfigModule {

    @Binds
    @Singleton
    abstract fun bindRemoteConfig(repository: RemoteConfigRepositoryImpl): RemoteConfigRepository
}