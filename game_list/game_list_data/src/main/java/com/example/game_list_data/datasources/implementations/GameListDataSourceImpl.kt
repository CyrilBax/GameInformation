package com.example.game_list_data.datasources.implementations

import com.example.game_list_data.datasources.GameListDataSource
import com.example.game_list_data.entities.GameListEntity
import com.example.game_list_data.sources.GameListSource
import javax.inject.Inject

class GameListDataSourceImpl @Inject constructor(
    private val service: GameListSource
) : GameListDataSource {

    override suspend fun getGameList(page: Int): GameListEntity {
        return service.getGameList(page)
    }
}