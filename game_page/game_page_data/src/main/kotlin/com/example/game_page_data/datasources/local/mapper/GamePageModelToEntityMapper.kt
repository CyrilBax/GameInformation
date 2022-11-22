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

class GamePageModelToEntityMapper @Inject constructor() : Mapper<GamePageModel, GamePageEntity> {

    override fun mapTo(from: GamePageModel): GamePageEntity {
        return GamePageEntity(
            id = from.id,
            name = from.name,
            description = from.description,
            rating = from.rating,
            reditLink = from.reditLink,
            reditDescription = from.reditDescription,
            platforms = mapPlatforms(from.platforms),
            genres = mapGenre(from.genres),
            tags = mapTag(from.tags)
        )
    }

    private fun mapPlatforms(platforms: List<PlatformModel>?): List<PlatformEntity>? {
        return platforms?.map { platform ->
            PlatformEntity(
                name = platform.name
            )
        }
    }

    private fun mapGenre(genres: List<GenreModel>?): List<GenreEntity>? {
        return genres?.map { genre ->
            GenreEntity(
                name = genre.name
            )
        }
    }

    private fun mapTag(tags: List<TagModel>?): List<TagEntity>? {
        return tags?.map { tag ->
            TagEntity(
                name = tag.name
            )
        }
    }
}