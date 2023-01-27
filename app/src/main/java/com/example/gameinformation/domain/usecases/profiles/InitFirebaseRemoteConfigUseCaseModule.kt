package com.example.gameinformation.domain.usecases.profiles

import com.example.gameinformation.domain.repositories.profiles.RemoteConfigModule
import com.example.gameinformation.domain.usecases.InitFirebaseRemoteConfigUseCase
import com.example.gameinformation.domain.usecases.implementations.InitFirebaseRemoteConfigUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [RemoteConfigModule::class])
@InstallIn(SingletonComponent::class)
abstract class InitFirebaseRemoteConfigUseCaseModule {

    @Binds
    abstract fun bindInitFirebaseRemoteConfigUse(useCase: InitFirebaseRemoteConfigUseCaseImpl): InitFirebaseRemoteConfigUseCase
}