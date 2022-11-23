package com.example.game_page_data.datasources.local.implementations

import com.example.commons.Mapper
import com.example.game_page_data.cache.GamePageDAO
import com.example.game_page_data.cache.GamePageDataBase
import com.example.game_page_data.cache.models.GamePageEntity
import com.example.game_page_data.datasources.local.GamePageLocalDataSource
import com.example.game_page_data.datasources.models.GamePageModel
import javax.inject.Inject

class GamePageLocalDataSourceImpl @Inject constructor(
    private val dataBase: GamePageDataBase,
    private val entityToModelMapper: Mapper<GamePageEntity, GamePageModel>,
    private val modelToEntityMapper: Mapper<GamePageModel, GamePageEntity>
) : GamePageLocalDataSource {

    private val gamePageDao: GamePageDAO = dataBase.getGamePageDao()

    override suspend fun getGamePage(gameId: String): GamePageModel? {
        val result = gamePageDao.getGamePage(gameId)

        result?.let {
            return entityToModelMapper.mapTo(it)
        } ?: return null
    }

    override suspend fun saveGamePage(gamePage: GamePageModel) {
        gamePageDao.saveGamePage(modelToEntityMapper.mapTo(gamePage))
    }

}