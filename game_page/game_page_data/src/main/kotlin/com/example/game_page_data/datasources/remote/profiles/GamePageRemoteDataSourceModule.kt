package com.example.game_page_data.datasources.remote.profiles

import com.example.commons.Mapper
import com.example.game_page_data.datasources.models.GamePageModel
import com.example.game_page_data.datasources.remote.GamePageRemoteDataSource
import com.example.game_page_data.datasources.remote.implementations.GamePageRemoteDataSourceImpl
import com.example.game_page_data.datasources.remote.mappers.GamePageRemoteToModelMapper
import com.example.game_page_data.services.models.GamePageModelRemote
import com.example.game_page_data.services.profiles.GamePageServiceModule
import dagger.Binds
import dagger.Module

@Module(includes = [GamePageServiceModule::class])
abstract class GamePageRemoteDataSourceModule {

    @Binds
    abstract fun bindGamePageRemoteDataSource(remoteDataSource: GamePageRemoteDataSourceImpl): GamePageRemoteDataSource

    @Binds
    abstract fun bindGamePageRemoteToModelMapper(mapper: GamePageRemoteToModelMapper): Mapper<GamePageModelRemote, GamePageModel>
}