package com.example.game_page_data.services.models

import com.google.gson.annotations.SerializedName

data class GamePageModelRemote(
    val id: String,
    val name: String?,
    val description: String?,
    @SerializedName("background_image")
    val backgroundImage: String?,
    val rating: Double?,
    @SerializedName("reddit_url")
    val reditLink: String?,
    @SerializedName("reddit_description")
    val reditDescription: String?,
    @SerializedName("parent_platforms")
    val platforms: List<ParentPlatform>?,
    val genres: List<GenreRemote>?,
    val tags: List<TagRemote>?
)

data class ParentPlatform(
    val platform: Platform
)

data class Platform(
    val slug: String
)

data class GenreRemote(
    val name: String
)

data class TagRemote(
    val name: String
)
