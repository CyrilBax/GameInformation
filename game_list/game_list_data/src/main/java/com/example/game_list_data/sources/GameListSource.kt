package com.example.game_list_data.sources

import com.example.game_list_data.sources.models.GameListRemoteModel

interface GameListSource {
    suspend fun getGameList(page: Int): GameListRemoteModel
}