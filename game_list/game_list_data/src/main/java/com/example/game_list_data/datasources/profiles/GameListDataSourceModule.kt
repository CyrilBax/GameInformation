package com.example.game_list_data.datasources.profiles

import com.example.game_list_data.datasources.GameListDataSource
import com.example.game_list_data.datasources.implementations.GameListDataSourceImpl
import com.example.game_list_data.sources.profiles.GameListSourceModule
import dagger.Binds
import dagger.Module

@Module(includes = [GameListSourceModule::class])
abstract class GameListDataSourceModule {

    @Binds
    abstract fun bindGameListDataSource(dataSource: GameListDataSourceImpl): GameListDataSource
}