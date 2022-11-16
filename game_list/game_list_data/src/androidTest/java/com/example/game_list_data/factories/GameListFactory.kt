package com.example.game_list_data.factories

import com.example.game_list_data.cache.models.GameLightEntity
import com.example.game_list_data.cache.models.GameListEntity
import com.example.game_list_data.cache.models.GenreEntity
import com.example.game_list_data.cache.models.PlatformEntity

object GameListFactory {

    fun getGameListEntity(page: Int): GameListEntity {
        return GameListEntity(
            page = page,
            next = "https://api.rawg.io/api/games?key=b93e15401f5e4b6ba8e982d50e192f75&page=2&page_size=20",
            previous = null,
            gameLight = listOf(
                GameLightEntity(
                    id = 3498,
                    name = "Grand Theft Auto V",
                    picture = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg",
                    rating = 4.47,
                    platforms = listOf(
                        PlatformEntity(name = "pc"),
                        PlatformEntity(name = "playstation"),
                        PlatformEntity(
                            name = "xbox"
                        )
                    ),
                    genres = listOf(GenreEntity(name = "Action"), GenreEntity(name = "Adventure"))
                ), GameLightEntity(
                    id = 3328,
                    name = "The Witcher 3: Wild Hunt",
                    picture = "https://media.rawg.io/media/games/618/618c2031a07bbff6b4f611f10b6bcdbc.jpg",
                    rating = 4.67,
                    platforms = listOf(
                        PlatformEntity(name = "pc"),
                        PlatformEntity(name = "playstation"),
                        PlatformEntity(name = "xbox"),
                        PlatformEntity(
                            name = "nintendo"
                        )
                    ),
                    genres = listOf(
                        GenreEntity(name = "Action"),
                        GenreEntity(name = "Adventure"),
                        GenreEntity(name = "RPG")
                    )
                ), GameLightEntity(
                    id = 4200,
                    name = "Portal 2",
                    picture = "https://media.rawg.io/media/games/328/3283617cb7d75d67257fc58339188742.jpg",
                    rating = 4.61,
                    platforms = listOf(
                        PlatformEntity(name = "pc"),
                        PlatformEntity(name = "playstation"),
                        PlatformEntity(name = "xbox"),
                        PlatformEntity(
                            name = "mac"
                        ),
                        PlatformEntity(name = "linux")
                    ),
                    genres = listOf(GenreEntity(name = "Shooter"), GenreEntity(name = "Puzzle"))
                ), GameLightEntity(
                    id = 5286,
                    name = "Tomb Raider (2013)",
                    picture = "https://media.rawg.io/media/games/021/021c4e21a1824d2526f925eff6324653.jpg",
                    rating = 4.05,
                    platforms = listOf(
                        PlatformEntity(name = "pc"),
                        PlatformEntity(name = "playstation"),
                        PlatformEntity(name = "xbox"),
                        PlatformEntity(
                            name = "mac"
                        )
                    ),
                    genres = listOf(GenreEntity(name = "Action"), GenreEntity(name = "Adventure"))
                ), GameLightEntity(
                    id = 4291,
                    name = "Counter - Strike: Global Offensive",
                    picture = "https://media.rawg.io/media/games/736/73619bd336c894d6941d926bfd563946.jpg",
                    rating = 3.57,
                    platforms = listOf(
                        PlatformEntity(name = "pc"),
                        PlatformEntity(name = "playstation"),
                        PlatformEntity(name = "xbox")
                    ),
                    genres = listOf(GenreEntity(name = "Action"), GenreEntity(name = "Shooter"))
                ), GameLightEntity(
                    id = 5679,
                    name = "The Elder Scrolls V : Skyrim",
                    picture = "https://media.rawg.io/media/games/7cf/7cfc9220b401b7a300e409e539c9afd5.jpg",
                    rating = 4.42,
                    platforms = listOf(
                        PlatformEntity(name = "pc"),
                        PlatformEntity(name = "playstation"),
                        PlatformEntity(name = "xbox"),
                        PlatformEntity(
                            name = "nintendo"
                        )
                    ),
                    genres = listOf(GenreEntity(name = "Action"), GenreEntity(name = "RPG"))
                ), GameLightEntity(
                    id = 12020,
                    name = "Left4 Dead 2",
                    picture = "https://media.rawg.io/media/games/d58/d588947d4286e7b5e0e12e1bea7d9844.jpg",
                    rating = 4.08,
                    platforms = listOf(
                        PlatformEntity(name = "pc"),
                        PlatformEntity(name = "xbox"),
                        PlatformEntity(name = "mac"),
                        PlatformEntity(
                            name = "linux"
                        )
                    ),
                    genres = listOf(GenreEntity(name = "Action"), GenreEntity(name = "Shooter"))
                ), GameLightEntity(
                    id = 13536,
                    name = "Portal",
                    picture = "https://media.rawg.io/media/games/7fa/7fa0b586293c5861ee32490e953a4996.jpg",
                    rating = 4.51,
                    platforms = listOf(
                        PlatformEntity(name = "pc"),
                        PlatformEntity(name = "playstation"),
                        PlatformEntity(name = "xbox"),
                        PlatformEntity(
                            name = "android"
                        ),
                        PlatformEntity(name = "mac"),
                        PlatformEntity(name = "linux"),
                        PlatformEntity(name = "nintendo")
                    ),
                    genres = listOf(GenreEntity(name = "Adventure"), GenreEntity(name = "Puzzle"))
                ), GameLightEntity(
                    id = 4062,
                    name = "BioShock Infinite",
                    picture = "https://media.rawg.io/media/games/fc1/fc1307a2774506b5bd65d7e8424664a7.jpg",
                    rating = 4.39,
                    platforms = listOf(
                        PlatformEntity(name = "pc"),
                        PlatformEntity(name = "playstation"),
                        PlatformEntity(name = "xbox"),
                        PlatformEntity(
                            name = "linux"
                        ),
                        PlatformEntity(name = "nintendo")
                    ),
                    genres = listOf(GenreEntity(name = "Action"), GenreEntity(name = "Shooter"))
                ), GameLightEntity(
                    id = 3439,
                    name = "Life is Strange",
                    picture = "https://media.rawg.io/media/games/562/562553814dd54e001a541e4ee83a591c.jpg",
                    rating = 4.11,
                    platforms = listOf(
                        PlatformEntity(name = "pc"),
                        PlatformEntity(name = "playstation"),
                        PlatformEntity(name = "xbox"),
                        PlatformEntity(
                            name = "ios"
                        ),
                        PlatformEntity(name = "android"),
                        PlatformEntity(name = "mac"),
                        PlatformEntity(name = "linux")
                    ),
                    genres = listOf(GenreEntity(name = "Adventure"))
                )
            )
        )
    }
}