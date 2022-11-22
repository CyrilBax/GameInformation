package com.example.game_page_domain.repositories.implementations

import com.example.commons.Mapper
import com.example.game_page_data.datasources.local.GamePageLocalDataSource
import com.example.game_page_data.datasources.models.GamePageModel
import com.example.game_page_data.datasources.remote.GamePageRemoteDataSource
import com.example.game_page_domain.models.GamePageModelUi
import com.example.game_page_domain.repositories.GamePageRepository
import javax.inject.Inject

class GamePageRepositoryImpl @Inject constructor(
    private val localDataSource: GamePageLocalDataSource,
    private val remoteDataSource: GamePageRemoteDataSource,
    private val mapper: Mapper<GamePageModel, GamePageModelUi>
) : GamePageRepository {

    override suspend fun getGamePage(gameId: String): GamePageModelUi {
        var gamePageResult = localDataSource.getGamePage(gameId)

        if (gamePageResult == null && remoteDataSource.isOnline()) {
            gamePageResult = remoteDataSource.getGamePage(gameId)

            localDataSource.saveGamePage(gamePageResult)
        } else {
            throw Error("Not found") // todo better way
        }

        return mapper.mapTo(gamePageResult)
    }
}