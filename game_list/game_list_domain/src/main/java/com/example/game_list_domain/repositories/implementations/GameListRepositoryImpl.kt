package com.example.game_list_domain.repositories.implementations

import com.example.commons.Mapper
import com.example.game_list_data.datasources.GameListDataSource
import com.example.game_list_data.entities.GameListEntity
import com.example.game_list_domain.models.GameListModelUi
import com.example.game_list_domain.repositories.GameListRepository
import javax.inject.Inject

class GameListRepositoryImpl @Inject constructor(
    private val dataSource: GameListDataSource,
    private val mapper: Mapper<GameListEntity, GameListModelUi>
) : GameListRepository {
    override suspend fun getGameList(page: Int): GameListModelUi {
        return mapper.mapTo(dataSource.getGameList(page))
    }
}