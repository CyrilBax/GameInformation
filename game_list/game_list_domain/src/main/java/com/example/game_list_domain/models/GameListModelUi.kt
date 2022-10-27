package com.example.game_list_domain.models

data class GameListModelUi(
    val next: String?,
    val previous: String?,
    val gameLights: List<GameLightUi>
)

data class GameLightUi(
    val id: Int,
    val name: String,
    val picture: String,
    val rating: Double,
    val platforms: List<PlatformUi>,
    val genreUis: List<GenreUi>
)

data class GenreUi(
    val name: String
)

data class PlatformUi(
    val name: String
)