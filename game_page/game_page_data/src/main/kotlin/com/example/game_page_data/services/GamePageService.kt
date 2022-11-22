package com.example.game_page_data.services

import com.example.game_page_data.services.models.GamePageModelRemote

interface GamePageService {

    suspend fun getGamePage(gameId: String): GamePageModelRemote
}