package com.example.game_page_data.services.implementations

import com.example.game_page_data.services.GamePageService
import com.example.game_page_data.services.Service
import com.example.game_page_data.services.models.GamePageModelRemote
import javax.inject.Inject

class GamePageServiceImpl @Inject constructor(
    private val service: Service
) : GamePageService {

    override suspend fun getGamePage(gameId: String): GamePageModelRemote {
        return service.getGamePage(gameId)
    }
}