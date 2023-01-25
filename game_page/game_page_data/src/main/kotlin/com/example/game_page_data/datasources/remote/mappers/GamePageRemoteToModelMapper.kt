package com.example.game_page_data.datasources.remote.mappers

import com.example.commons.Mapper
import com.example.game_page_data.datasources.models.GamePageModel
import com.example.game_page_data.datasources.models.GenreModel
import com.example.game_page_data.datasources.models.PlatformModel
import com.example.game_page_data.datasources.models.TagModel
import com.example.game_page_data.services.models.*
import javax.inject.Inject

class GamePageRemoteToModelMapper @Inject constructor() :
    Mapper<GamePageModelRemote, GamePageModel> {

    override fun mapTo(from: GamePageModelRemote): GamePageModel {
        return GamePageModel(
            id = from.id,
            name = from.name,
            description = from.description,
            pictureUrl = from.backgroundImage,
            rating = from.rating,
            reditLink = from.reditLink,
            reditDescription = from.reditDescription,
            platforms = mapPlatforms(from.platforms),
            genres = mapGenre(from.genres),
            tags = mapTag(from.tags)
        )
    }

    private fun mapPlatforms(platforms: List<ParentPlatform>?): List<PlatformModel>? {
        return platforms?.map { platform ->
            PlatformModel(
                name = platform.platform.slug
            )
        }
    }

    private fun mapGenre(genres: List<GenreRemote>?): List<GenreModel>? {
        return genres?.map { genre ->
            GenreModel(
                name = genre.name
            )
        }
    }

    private fun mapTag(tags: List<TagRemote>?): List<TagModel>? {
        return tags?.map { tag ->
            TagModel(
                name = tag.name
            )
        }
    }
}