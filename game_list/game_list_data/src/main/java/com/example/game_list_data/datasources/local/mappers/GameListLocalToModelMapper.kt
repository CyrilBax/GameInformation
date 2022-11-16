package com.example.game_list_data.datasources.local.mappers

import com.example.commons.Mapper
import com.example.game_list_data.cache.models.GameLightEntity
import com.example.game_list_data.cache.models.GameListEntity
import com.example.game_list_data.cache.models.GenreEntity
import com.example.game_list_data.cache.models.PlatformEntity
import com.example.game_list_data.datasources.models.GameLightModel
import com.example.game_list_data.datasources.models.GameListModel
import com.example.game_list_data.datasources.models.GenreModel
import com.example.game_list_data.datasources.models.PlatformModel
import javax.inject.Inject

class GameListLocalToModelMapper @Inject constructor() : Mapper<GameListEntity, GameListModel> {

    override fun mapTo(from: GameListEntity): GameListModel {
        return GameListModel(
            next = from.next,
            previous = from.previous,
            gameLights = from.gameLight.map { mapGameLight(it) }
        )
    }

    private fun mapGameLight(from: GameLightEntity): GameLightModel {
        return GameLightModel(
            id = from.id,
            name = from.name,
            picture = from.picture,
            rating = from.rating,
            platforms = from.platforms?.map { mapPlatforms(it) },
            genre = from.genres?.map { mapGenre(it) }
        )
    }

    private fun mapPlatforms(from: PlatformEntity): PlatformModel {
        return PlatformModel(
            name = from.name
        )
    }

    private fun mapGenre(from: GenreEntity): GenreModel {
        return GenreModel(
            name = from.name
        )
    }
}