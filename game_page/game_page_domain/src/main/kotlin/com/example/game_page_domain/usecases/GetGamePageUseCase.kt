package com.example.game_page_domain.usecases

import com.example.game_page_domain.models.GamePageModelUi

interface GetGamePageUseCase {

    suspend fun execute(gameId: String): GamePageModelUi
}