package com.example.business.domain.profiles

import com.example.business.domain.usecases.GetRawgApiKeyUseCase
import com.example.business.domain.usecases.implementations.GetRawgApiKeyUseCaseImpl
import dagger.Binds
import dagger.Module

@Module(includes = [RawgApiKeyRepositoryModule::class])
abstract class GetRawgApiKeyUseCaseModule {

    @Binds
    abstract fun bindGetRawgApiKeyUseCase(useCase: GetRawgApiKeyUseCaseImpl): GetRawgApiKeyUseCase
}