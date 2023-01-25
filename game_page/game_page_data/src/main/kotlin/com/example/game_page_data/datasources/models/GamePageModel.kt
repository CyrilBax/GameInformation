package com.example.game_page_data.datasources.models

data class GamePageModel(
    val id: String,
    val name: String?,
    val description: String?,
    val pictureUrl: String?,
    val rating: Double?,
    val reditLink: String?,
    val reditDescription: String?,
    val platforms: List<PlatformModel>?,
    val genres: List<GenreModel>?,
    val tags: List<TagModel>?
)

data class PlatformModel(
    val name: String
)

data class GenreModel(
    val name: String
)

data class TagModel(
    val name: String
)
