package com.example.game_list_domain.repositories

import com.example.game_list_domain.models.GameListModelUi

interface GameListRepository {

    suspend fun getGameList(page: Int): GameListModelUi
}