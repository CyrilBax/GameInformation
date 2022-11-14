package com.example.game_list_data.datasources.remote.profiles

import com.example.commons.Mapper
import com.example.game_list_data.datasources.models.GameListModel
import com.example.game_list_data.datasources.remote.GameListRemoteDataSource
import com.example.game_list_data.datasources.remote.implementations.GameListRemoteDataSourceImpl
import com.example.game_list_data.datasources.remote.mappers.GameListRemoteToModelMapper
import com.example.game_list_data.sources.models.GameListRemoteModel
import com.example.game_list_data.sources.profiles.GameListSourceModule
import dagger.Binds
import dagger.Module

@Module(includes = [GameListSourceModule::class])
abstract class GameListRemoteDataSourceModule {

    @Binds
    abstract fun bindGameListDataSource(dataSource: GameListRemoteDataSourceImpl): GameListRemoteDataSource

    @Binds
    abstract fun bindGameListRemoteToModelMapper(mapper: GameListRemoteToModelMapper): Mapper<GameListRemoteModel, GameListModel>
}