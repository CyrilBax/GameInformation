package com.example.gameinformation.domain.usecases.profiles

import com.example.gameinformation.domain.repositories.profiles.RemoteConfigModule
import com.example.gameinformation.domain.usecases.IsComposeEnableUseCase
import com.example.gameinformation.domain.usecases.implementations.IsComposeEnableUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [RemoteConfigModule::class])
@InstallIn(SingletonComponent::class)
abstract class IsComposeEnableUseCaseModule {

    @Binds
    abstract fun bindIsComposeEnableUseCase(useCase: IsComposeEnableUseCaseImpl): IsComposeEnableUseCase
}