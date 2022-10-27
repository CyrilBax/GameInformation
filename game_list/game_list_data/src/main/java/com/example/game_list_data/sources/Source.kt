package com.example.game_list_data.sources

import com.example.game_list_data.entities.GameListEntity
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface Source {

    @GET(PATH_GET_GAME_LIST)
    suspend fun getGameList(
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int,
        @Query("key") key: String,
        @Header("Content-Type") contentType: String? = "application/json"
    ): GameListEntity

    companion object {
        private const val PATH_GET_GAME_LIST = "games"
    }
}