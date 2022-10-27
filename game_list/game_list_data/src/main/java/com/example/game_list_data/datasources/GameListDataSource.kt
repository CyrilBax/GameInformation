package com.example.game_list_data.datasources

import com.example.game_list_data.entities.GameListEntity

interface GameListDataSource {

    suspend fun getGameList(page: Int): GameListEntity
}