package com.example.game_list_data.sources

import com.example.game_list_data.entities.GameListEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface Source {

    @GET(PATH_GET_GAME_LIST)
    suspend fun getGameList(
        @Path("page") page: Int,
        @Path("page_size") pageSize: Int
    ): GameListEntity

    companion object {
        private const val PATH_GET_GAME_LIST = "/games"
    }
}