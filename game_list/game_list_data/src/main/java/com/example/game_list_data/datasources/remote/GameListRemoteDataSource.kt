package com.example.game_list_data.datasources.remote

import com.example.game_list_data.datasources.models.GameListModel

interface GameListRemoteDataSource {

    suspend fun getGameList(page: Int): GameListModel

    suspend fun isOnline(): Boolean
}