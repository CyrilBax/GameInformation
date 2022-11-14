package com.example.game_list_domain.repositories.implementations

import com.example.commons.Mapper
import com.example.game_list_data.datasources.local.GameListLocalDataSource
import com.example.game_list_data.datasources.models.GameListModel
import com.example.game_list_data.datasources.remote.GameListRemoteDataSource
import com.example.game_list_domain.models.GameListModelUi
import com.example.game_list_domain.repositories.GameListRepository
import timber.log.Timber
import javax.inject.Inject

class GameListRepositoryImpl @Inject constructor(
    private val localDatasource: GameListLocalDataSource,
    private val remoteDataSource: GameListRemoteDataSource,
    private val mapper: Mapper<GameListModel, GameListModelUi>
) : GameListRepository {

    override suspend fun getGameList(page: Int): GameListModelUi {
        return try {
            var gameList = localDatasource.getGameList(page)

            if (gameList.gameLights.isEmpty() && remoteDataSource.isOnline()) {
                gameList = remoteDataSource.getGameList(page)
                localDatasource.saveGameList(gameList)
            }

            mapper.mapTo(gameList)

        } catch (e: java.lang.Exception) {
            Timber.e(e)
            return GameListModelUi(
                next = page.toString(),
                previous = null,
                gameLights = emptyList()
            )
        }
    }
}