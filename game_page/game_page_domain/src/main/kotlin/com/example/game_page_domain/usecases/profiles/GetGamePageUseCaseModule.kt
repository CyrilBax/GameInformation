package com.example.game_page_domain.usecases.profiles

import com.example.game_page_domain.repositories.profiles.GamePageRepositoryModule
import com.example.game_page_domain.usecases.GetGamePageUseCase
import com.example.game_page_domain.usecases.implementations.GetGamePageUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module(includes = [GamePageRepositoryModule::class])
@InstallIn(ViewModelComponent::class)
abstract class GetGamePageUseCaseModule {

    @Binds
    abstract fun bindGetGamePageUseCase(useCase: GetGamePageUseCaseImpl): GetGamePageUseCase
}