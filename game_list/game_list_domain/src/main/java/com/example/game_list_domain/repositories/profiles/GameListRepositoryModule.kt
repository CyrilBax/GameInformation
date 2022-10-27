package com.example.game_list_domain.repositories.profiles

import com.example.commons.Mapper
import com.example.game_list_data.datasources.profiles.GameListDataSourceModule
import com.example.game_list_data.entities.GameListEntity
import com.example.game_list_domain.mappers.GameListMapper
import com.example.game_list_domain.models.GameListModelUi
import com.example.game_list_domain.repositories.GameListRepository
import com.example.game_list_domain.repositories.implementations.GameListRepositoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [GameListDataSourceModule::class])
abstract class GameListRepositoryModule {

    @Binds
    abstract fun bindGameListRepository(repository: GameListRepositoryImpl): GameListRepository

    @Binds
    abstract fun bindGameListMapper(mapper: GameListMapper): Mapper<GameListEntity, GameListModelUi>
}