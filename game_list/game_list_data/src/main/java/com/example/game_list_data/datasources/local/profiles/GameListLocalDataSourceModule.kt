package com.example.game_list_data.datasources.local.profiles

import com.example.commons.Mapper
import com.example.game_list_data.cache.models.GameListEntity
import com.example.game_list_data.cache.profiles.GameListDataBaseModule
import com.example.game_list_data.datasources.local.GameListLocalDataSource
import com.example.game_list_data.datasources.local.implementations.GameListLocalDataSourceImpl
import com.example.game_list_data.datasources.local.mappers.GameListLocalToModelMapper
import com.example.game_list_data.datasources.local.mappers.GameListModelToLocalMapper
import com.example.game_list_data.datasources.models.GameListModel
import dagger.Binds
import dagger.Module

@Module(includes = [GameListDataBaseModule::class])
abstract class GameListLocalDataSourceModule {

    @Binds
    abstract fun bindGameListLocalDataSource(localDataSource: GameListLocalDataSourceImpl): GameListLocalDataSource

    @Binds
    abstract fun bindGameListLocalToModelMapper(mapper: GameListLocalToModelMapper): Mapper<GameListEntity, GameListModel>

    @Binds
    abstract fun bindGameListModelToLocalMapper(mapper: GameListModelToLocalMapper): Mapper<GameListModel, GameListEntity>

}