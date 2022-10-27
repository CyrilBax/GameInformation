package com.example.game_list_data.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class GameListEntity(
    val next: String?,
    val previous: String?,
    val gameLights: List<GameLight>
)

data class GameLight(
    val id: Int,
    val name: String,
    @SerialName("background_image")
    val backgroundImage: String,
    val rating: Double,
    @SerialName("parent_platforms")
    val parentPlatforms: List<ParentPlatform>,
    val genres: List<Genre>
)

data class Genre(
    val name: String
)

@Serializable
data class ParentPlatform(
    val platform: Platform
)

@Serializable
data class Platform(
    val slug: String
)
