package com.example.game_list_domain.usecases.implementations

import com.example.game_list_domain.models.GameListModelUi
import com.example.game_list_domain.repositories.GameListRepository
import com.example.game_list_domain.usecases.GetGameListUseCase
import javax.inject.Inject

class GetGameListUseCaseImpl @Inject constructor(
    private val repository: GameListRepository
) : GetGameListUseCase {

    override suspend fun execute(page: Int): GameListModelUi = repository.getGameList(page)
}