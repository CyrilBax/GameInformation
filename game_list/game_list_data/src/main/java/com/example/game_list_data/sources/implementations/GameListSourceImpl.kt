package com.example.game_list_data.sources.implementations

import com.example.game_list_data.sources.GameListSource
import com.example.game_list_data.sources.Source
import com.example.game_list_data.sources.models.GameListRemoteModel
import javax.inject.Inject

class GameListSourceImpl @Inject constructor(
    private val source: Source
) : GameListSource {
    override suspend fun getGameList(page: Int): GameListRemoteModel {
        return source.getGameList(
            page = page,
            pageSize = 20
        )
    }
}