package com.example.game_page_data.datasources.local.profiles

import com.example.commons.Mapper
import com.example.game_page_data.cache.models.GamePageEntity
import com.example.game_page_data.cache.profiles.GamePageDataBaseModule
import com.example.game_page_data.datasources.local.GamePageLocalDataSource
import com.example.game_page_data.datasources.local.implementations.GamePageLocalDataSourceImpl
import com.example.game_page_data.datasources.local.mapper.GamePageEntityToModelMapper
import com.example.game_page_data.datasources.local.mapper.GamePageModelToEntityMapper
import com.example.game_page_data.datasources.models.GamePageModel
import dagger.Binds
import dagger.Module

@Module(includes = [GamePageDataBaseModule::class])
abstract class GamePageLocalDataSourceModule {

    @Binds
    abstract fun bindGamePageLocalDataSource(localDataSource: GamePageLocalDataSourceImpl): GamePageLocalDataSource

    @Binds
    abstract fun bindGamePageEntityToModelMapper(mapper: GamePageEntityToModelMapper): Mapper<GamePageEntity, GamePageModel>

    @Binds
    abstract fun bindGamePageModelToEntityMapper(mapper: GamePageModelToEntityMapper): Mapper<GamePageModel, GamePageEntity>
}