package com.example.game_list_domain.usecases

import com.example.game_list_domain.models.GameListModelUi

interface GetGameListUseCase {
    suspend fun execute(page: Int): GameListModelUi
}