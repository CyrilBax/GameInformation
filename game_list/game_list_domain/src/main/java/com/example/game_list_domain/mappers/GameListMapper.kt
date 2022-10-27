package com.example.game_list_domain.mappers

import com.example.commons.Mapper
import com.example.game_list_data.entities.GameLight
import com.example.game_list_data.entities.GameListEntity
import com.example.game_list_data.entities.Genre
import com.example.game_list_data.entities.ParentPlatform
import com.example.game_list_domain.models.GameLightUi
import com.example.game_list_domain.models.GameListModelUi
import com.example.game_list_domain.models.GenreUi
import com.example.game_list_domain.models.PlatformUi
import javax.inject.Inject

class GameListMapper @Inject constructor() : Mapper<GameListEntity, GameListModelUi> {
    override fun mapTo(from: GameListEntity): GameListModelUi {
        return GameListModelUi(
            next = from.next,
            previous = from.previous,
            gameLights = mapGameLight(from.gameLights)
        )
    }

    private fun mapGameLight(games: List<GameLight>): List<GameLightUi> {
        return games.map { game ->
            GameLightUi(
                id = game.id,
                name = game.name,
                picture = game.backgroundImage,
                rating = game.rating,
                platforms = mapPlatforms(game.parentPlatforms),
                genreUis = mapGenres(game.genres)
            )
        }
    }

    private fun mapPlatforms(platforms: List<ParentPlatform>): List<PlatformUi> {
        return platforms.map { platform ->
            PlatformUi(
                name = platform.platform.slug
            )
        }
    }

    private fun mapGenres(genres: List<Genre>): List<GenreUi> {
        return genres.map { genre ->
            GenreUi(
                name = genre.name
            )
        }
    }
}