package com.example.game_list_domain.repositories.profiles

import com.example.commons.Mapper
import com.example.game_list_data.datasources.local.profiles.GameListLocalDataSourceModule
import com.example.game_list_data.datasources.models.GameListModel
import com.example.game_list_data.datasources.remote.profiles.GameListRemoteDataSourceModule
import com.example.game_list_domain.mappers.GameListMapper
import com.example.game_list_domain.models.GameListModelUi
import com.example.game_list_domain.repositories.GameListRepository
import com.example.game_list_domain.repositories.implementations.GameListRepositoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [GameListRemoteDataSourceModule::class, GameListLocalDataSourceModule::class])
abstract class GameListRepositoryModule {

    @Binds
    abstract fun bindGameListRepository(repository: GameListRepositoryImpl): GameListRepository

    @Binds
    abstract fun bindGameListMapper(mapper: GameListMapper): Mapper<GameListModel, GameListModelUi>
}