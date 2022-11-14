package com.example.game_list_data.datasources.local.implementations

import com.example.commons.Mapper
import com.example.game_list_data.cache.GameListDAO
import com.example.game_list_data.cache.GameListDataBase
import com.example.game_list_data.cache.models.GameListEntity
import com.example.game_list_data.datasources.local.GameListLocalDataSource
import com.example.game_list_data.datasources.models.GameListModel
import timber.log.Timber
import javax.inject.Inject

class GameListLocalDataSourceImpl @Inject constructor(
    cache: GameListDataBase,
    private val entityToModelMapper: Mapper<GameListEntity, GameListModel>,
    private val modelToEntityMapper: Mapper<GameListModel, GameListEntity>
) : GameListLocalDataSource {

    private val gameListDAO: GameListDAO = cache.getGameListDao()

    override suspend fun getGameList(page: Int): GameListModel {
        return try {
            entityToModelMapper.mapTo(gameListDAO.getGameListPage(page))
        } catch (e: java.lang.Exception) {
            Timber.e(e)
            GameListModel(
                next = null,
                previous = null,
                gameLights = emptyList()
            )
        }
    }

    override suspend fun saveGameList(gameList: GameListModel) {
        gameListDAO.saveGameList(modelToEntityMapper.mapTo(gameList))
    }
}