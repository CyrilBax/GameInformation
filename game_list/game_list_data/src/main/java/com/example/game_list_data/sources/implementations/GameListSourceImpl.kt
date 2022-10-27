package com.example.game_list_data.sources.implementations

import com.example.game_list_data.entities.GameListEntity
import com.example.game_list_data.sources.GameListSource
import com.example.game_list_data.sources.Source
import javax.inject.Inject

class GameListSourceImpl @Inject constructor(
    private val source: Source
) : GameListSource {
    override suspend fun getGameList(page: Int): GameListEntity {
        return source.getGameList(
            page = page,
            pageSize = 20
        )
    }
}