package com.example.game_list_data.datasources.remote.mappers

import com.example.commons.Mapper
import com.example.game_list_data.datasources.models.GameLightModel
import com.example.game_list_data.datasources.models.GameListModel
import com.example.game_list_data.datasources.models.GenreModel
import com.example.game_list_data.datasources.models.PlatformModel
import com.example.game_list_data.sources.models.GameLight
import com.example.game_list_data.sources.models.GameListRemoteModel
import com.example.game_list_data.sources.models.Genre
import com.example.game_list_data.sources.models.ParentPlatform
import javax.inject.Inject

class GameListRemoteToModelMapper @Inject constructor() :
    Mapper<GameListRemoteModel, GameListModel> {

    override fun mapTo(from: GameListRemoteModel): GameListModel {
        return GameListModel(
            next = from.next,
            previous = from.previous,
            gameLights = from.results.map { mapGameLight(it) }
        )
    }

    private fun mapGameLight(from: GameLight): GameLightModel {
        return GameLightModel(
            id = from.id,
            name = from.name,
            picture = from.backgroundImage,
            rating = from.rating,
            platforms = from.parentPlatforms?.map { mapPlatform(it) },
            genre = from.genres?.map { mapGenre(it) }
        )
    }

    private fun mapPlatform(from: ParentPlatform): PlatformModel {
        return PlatformModel(
            name = from.platform?.slug
        )
    }

    private fun mapGenre(from: Genre): GenreModel {
        return GenreModel(
            name = from.name
        )
    }
}