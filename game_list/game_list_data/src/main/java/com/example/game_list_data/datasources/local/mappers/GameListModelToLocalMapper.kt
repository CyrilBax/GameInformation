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

class GameListModelToLocalMapper @Inject constructor() : Mapper<GameListModel, GameListEntity> {

    override fun mapTo(from: GameListModel): GameListEntity {
        return GameListEntity(
            page = getPage(from.next, from.previous) ?: 1,
            next = from.next,
            previous = from.previous,
            gameLight = from.gameLights.map { mapGameLight(it) }
        )
    }

    private fun getPage(next: String?, previous: String?): Int? {
        var page: Int? = null

        next?.let {
            page = it.substringAfter("page=").substringBefore("&").toInt() - 1
        } ?: previous?.let {
            page = it.substringAfter("page=").substringBefore("&").toInt() + 1
        }

        return page
    }

    private fun mapGameLight(from: GameLightModel): GameLightEntity {
        return GameLightEntity(
            id = from.id,
            name = from.name,
            picture = from.picture,
            rating = from.rating,
            platforms = from.platforms?.map { mapPlatforms(it) },
            genres = from.genre?.map { mapGenre(it) }
        )
    }

    private fun mapPlatforms(from: PlatformModel): PlatformEntity {
        return PlatformEntity(
            name = from.name
        )
    }

    private fun mapGenre(from: GenreModel): GenreEntity {
        return GenreEntity(
            name = from.name
        )
    }

}