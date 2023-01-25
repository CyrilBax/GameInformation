package com.example.game_page_data.datasources.local.mapper

import com.example.commons.Mapper
import com.example.game_page_data.cache.models.GamePageEntity
import com.example.game_page_data.cache.models.GenreEntity
import com.example.game_page_data.cache.models.PlatformEntity
import com.example.game_page_data.cache.models.TagEntity
import com.example.game_page_data.datasources.models.GamePageModel
import com.example.game_page_data.datasources.models.GenreModel
import com.example.game_page_data.datasources.models.PlatformModel
import com.example.game_page_data.datasources.models.TagModel
import javax.inject.Inject

class GamePageEntityToModelMapper @Inject constructor() : Mapper<GamePageEntity, GamePageModel> {

    override fun mapTo(from: GamePageEntity): GamePageModel {
        return GamePageModel(
            id = from.id,
            name = from.name,
            description = from.description,
            pictureUrl = from.pictureUrl,
            rating = from.rating,
            reditLink = from.reditLink,
            reditDescription = from.reditDescription,
            platforms = mapPlatforms(from.platforms),
            genres = mapGenre(from.genres),
            tags = mapTag(from.tags)
        )
    }

    private fun mapPlatforms(platforms: List<PlatformEntity>?): List<PlatformModel>? {
        return platforms?.map { platform ->
            PlatformModel(
                name = platform.name
            )
        }
    }

    private fun mapGenre(genres: List<GenreEntity>?): List<GenreModel>? {
        return genres?.map { genre ->
            GenreModel(
                name = genre.name
            )
        }
    }

    private fun mapTag(tags: List<TagEntity>?): List<TagModel>? {
        return tags?.map { tag ->
            TagModel(
                name = tag.name
            )
        }
    }
}