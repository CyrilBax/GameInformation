package com.example.game_list_domain.usecases.profiles

import com.example.game_list_domain.repositories.profiles.GameListRepositoryModule
import com.example.game_list_domain.usecases.GetGameListUseCase
import com.example.game_list_domain.usecases.implementations.GetGameListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module(includes = [GameListRepositoryModule::class])
abstract class GetGameListUseCaseModule {

    @Binds
    abstract fun bindGetGameListUseCase(useCase: GetGameListUseCaseImpl): GetGameListUseCase
}