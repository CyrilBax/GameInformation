package com.example.game_list_domain.mappers

import com.example.commons.Mapper
import com.example.game_list_data.datasources.models.GameLightModel
import com.example.game_list_data.datasources.models.GameListModel
import com.example.game_list_data.datasources.models.GenreModel
import com.example.game_list_data.datasources.models.PlatformModel
import com.example.game_list_domain.models.GameLightUi
import com.example.game_list_domain.models.GameListModelUi
import com.example.game_list_domain.models.GenreUi
import com.example.game_list_domain.models.PlatformUi
import javax.inject.Inject

class GameListMapper @Inject constructor() : Mapper<GameListModel, GameListModelUi> {
    override fun mapTo(from: GameListModel): GameListModelUi {
        return GameListModelUi(
            next = from.next,
            previous = from.previous,
            gameLights = mapGameLight(from.gameLights)
        )
    }

    private fun mapGameLight(games: List<GameLightModel>): List<GameLightUi> {
        return games.map { game ->
            GameLightUi(
                id = game.id,
                name = game.name,
                picture = game.picture,
                rating = game.rating,
                platforms = mapPlatforms(game.platforms),
                genreUis = mapGenres(game.genre)
            )
        }
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
}