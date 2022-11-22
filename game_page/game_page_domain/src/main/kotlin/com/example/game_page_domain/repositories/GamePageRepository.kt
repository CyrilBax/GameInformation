package com.example.game_page_domain.repositories

import com.example.game_page_domain.models.GamePageModelUi

interface GamePageRepository {

    suspend fun getGamePage(gameId: String): GamePageModelUi
}