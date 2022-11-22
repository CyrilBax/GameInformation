package com.example.game_page_data.datasources.remote

import com.example.game_page_data.datasources.models.GamePageModel

interface GamePageRemoteDataSource {

    suspend fun getGamePage(gameId: String): GamePageModel

    suspend fun isOnline(): Boolean
}