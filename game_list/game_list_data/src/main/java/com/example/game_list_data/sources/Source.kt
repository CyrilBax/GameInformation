package com.example.game_list_data.sources

import com.example.game_list_data.sources.models.GameListRemoteModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface Source {

    @GET(PATH_GET_GAME_LIST)
    suspend fun getGameList(
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int
    ): GameListRemoteModel

    companion object {
        private const val PATH_GET_GAME_LIST = "games"
    }
}