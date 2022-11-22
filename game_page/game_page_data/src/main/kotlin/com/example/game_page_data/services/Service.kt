package com.example.game_page_data.services

import androidx.room.Query
import com.example.game_page_data.services.models.GamePageModelRemote
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {

    @GET(PATH_GET_GAME_PAGE)
    suspend fun getGamePage(
        @Path("id") gameId: String
    ): GamePageModelRemote

    companion object {
        private const val PATH_GET_GAME_PAGE = "games/{id}"
    }
}