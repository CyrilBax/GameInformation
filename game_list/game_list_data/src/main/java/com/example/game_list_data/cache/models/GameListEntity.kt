package com.example.game_list_data.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GameListEntity(
    @PrimaryKey(autoGenerate = false)
    var page: Int,
    val next: String?,
    val previous: String?,
    val gameLight: List<GameLightEntity>
)

data class GameLightEntity(
    val id: Int?,
    val name: String?,
    val picture: String?,
    val rating: Double?,
    val platforms: List<PlatformEntity>?,
    val genres: List<GenreEntity>?
)

data class GenreEntity(
    val name: String?
)

data class PlatformEntity(
    val name: String?
)