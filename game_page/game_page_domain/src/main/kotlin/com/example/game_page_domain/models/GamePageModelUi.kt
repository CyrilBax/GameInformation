package com.example.game_page_domain.models

data class GamePageModelUi(
    val id: String,
    val name: String?,
    val description: String?,
    val rating: Long?,
    val reditLink: String?,
    val reditDescription: String?,
    val platformUis: List<PlatformUi>?,
    val genres: List<GenreUi>?,
    val tags: List<TagUi>?
)

data class PlatformUi(
    val name: String
)

data class GenreUi(
    val name: String
)

data class TagUi(
    val name: String
)
