package com.example.game_list_data.datasources.local

import com.example.game_list_data.datasources.models.GameListModel

interface GameListLocalDataSource {

    suspend fun getGameList(page: Int): GameListModel

    suspend fun saveGameList(gameList: GameListModel)
}