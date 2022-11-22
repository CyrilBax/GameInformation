package com.example.game_page_data.datasources.local

import com.example.game_page_data.datasources.models.GamePageModel

interface GamePageLocalDataSource {

    suspend fun getGamePage(gameId: String): GamePageModel?

    suspend fun saveGamePage(gamePage: GamePageModel)
}