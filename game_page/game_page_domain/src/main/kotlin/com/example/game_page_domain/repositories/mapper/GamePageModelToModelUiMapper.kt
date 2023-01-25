package com.example.game_page_domain.repositories.mapper

import com.example.commons.Mapper
import com.example.game_page_data.datasources.models.GamePageModel
import com.example.game_page_data.datasources.models.GenreModel
import com.example.game_page_data.datasources.models.PlatformModel
import com.example.game_page_data.datasources.models.TagModel
import com.example.game_page_domain.models.GamePageModelUi
import com.example.game_page_domain.models.GenreUi
import com.example.game_page_domain.models.PlatformUi
import com.example.game_page_domain.models.TagUi
import javax.inject.Inject

class GamePageModelToModelUiMapper @Inject constructor() : Mapper<GamePageModel, GamePageModelUi> {

    override fun mapTo(from: GamePageModel): GamePageModelUi {
        return GamePageModelUi(
            id = from.id,
            name = from.name,
            description = from.description,
            pictureUrl = from.pictureUrl,
            rating = from.rating,
            reditLink = from.reditLink,
            reditDescription = from.reditDescription,
            platformUis = mapPlatforms(from.platforms),
            genres = mapGenres(from.genres),
            tags = mapTag(from.tags)
        )
    }

    private fun mapPlatforms(platforms: List<PlatformModel>?): List<PlatformUi>? {
        return platforms?.map { platform ->
            PlatformUi(
                name = platform.name
            )
        }
    }

    private fun mapGenres(genres: List<GenreModel>?): List<GenreUi>? {
        return genres?.map { genre ->
            GenreUi(
                name = genre.name
            )
        }
    }

    private fun mapTag(tags: List<TagModel>?): List<TagUi>? {
        return tags?.map { tag ->
            TagUi(
                name = tag.name
            )
        }
    }
}