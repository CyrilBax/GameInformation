package com.example.game_page_domain.repositories.profiles

import com.example.commons.Mapper
import com.example.game_page_data.datasources.local.profiles.GamePageLocalDataSourceModule
import com.example.game_page_data.datasources.models.GamePageModel
import com.example.game_page_data.datasources.remote.profiles.GamePageRemoteDataSourceModule
import com.example.game_page_domain.models.GamePageModelUi
import com.example.game_page_domain.repositories.GamePageRepository
import com.example.game_page_domain.repositories.implementations.GamePageRepositoryImpl
import com.example.game_page_domain.repositories.mapper.GamePageModelToModelUiMapper
import dagger.Binds
import dagger.Module

@Module(includes = [GamePageLocalDataSourceModule::class, GamePageRemoteDataSourceModule::class])
abstract class GamePageRepositoryModule {

    @Binds
    abstract fun bindGamePageRepository(repositoryImpl: GamePageRepositoryImpl): GamePageRepository

    @Binds
    abstract fun bindGamePageModelToModelUiMapper(mapper: GamePageModelToModelUiMapper): Mapper<GamePageModel, GamePageModelUi>
}