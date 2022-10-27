package com.example.game_list_data.sources

import com.example.game_list_data.entities.GameListEntity

interface GameListSource {
    suspend fun getGameList(page: Int): GameListEntity
}