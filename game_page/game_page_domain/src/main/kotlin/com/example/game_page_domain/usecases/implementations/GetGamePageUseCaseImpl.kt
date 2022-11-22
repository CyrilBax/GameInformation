package com.example.game_page_domain.usecases.implementations

import com.example.game_page_domain.models.GamePageModelUi
import com.example.game_page_domain.repositories.GamePageRepository
import com.example.game_page_domain.usecases.GetGamePageUseCase
import javax.inject.Inject

class GetGamePageUseCaseImpl @Inject constructor(
    private val repository: GamePageRepository
) : GetGamePageUseCase {
    override suspend fun execute(gameId: String): GamePageModelUi {
        return repository.getGamePage(gameId)
    }
}