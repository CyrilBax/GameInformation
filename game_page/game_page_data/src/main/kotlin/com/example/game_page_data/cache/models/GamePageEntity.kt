package com.example.game_page_data.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GamePageEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String?,
    val description: String?,
    val pictureUrl: String?,
    val rating: Double?,
    val reditLink: String?,
    val reditDescription: String?,
    val platforms: List<PlatformEntity>?,
    val genres: List<GenreEntity>?,
    val tags: List<TagEntity>?
)

data class PlatformEntity(
    val name: String
)

data class GenreEntity(
    val name: String
)

data class TagEntity(
    val name: String
)