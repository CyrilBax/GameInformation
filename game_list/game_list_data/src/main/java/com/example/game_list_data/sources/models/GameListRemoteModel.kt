package com.example.game_list_data.sources.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class GameListRemoteModel(
    val next: String?,
    val previous: String?,
    val results: List<GameLight>
)

data class GameLight(
    val id: Int?,
    val name: String?,
    @SerializedName("background_image")
    val backgroundImage: String?,
    val rating: Double?,
    @SerializedName("parent_platforms")
    val parentPlatforms: List<ParentPlatform>?,
    val genres: List<Genre>?
)

data class Genre(
    val name: String?
)

@Serializable
data class ParentPlatform(
    val platform: Platform?
)

@Serializable
data class Platform(
    val slug: String?
)
