package com.example.game_list_data.datasources.models

data class GameListModel(
    val next: String?,
    val previous: String?,
    val gameLights: List<GameLightModel>
)

data class GameLightModel(
    val id: Int?,
    val name: String?,
    val picture: String?,
    val rating: Double?,
    val platforms: List<PlatformModel>?,
    val genre: List<GenreModel>?
)

data class GenreModel(
    val name: String?
)

data class PlatformModel(
    val name: String?
)