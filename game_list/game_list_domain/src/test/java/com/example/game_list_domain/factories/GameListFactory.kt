package com.example.game_list_domain.factories

import com.example.game_list_data.datasources.models.GameLightModel
import com.example.game_list_data.datasources.models.GameListModel
import com.example.game_list_data.datasources.models.GenreModel
import com.example.game_list_data.datasources.models.PlatformModel
import com.example.game_list_domain.models.GameLightUi
import com.example.game_list_domain.models.GameListModelUi
import com.example.game_list_domain.models.GenreUi
import com.example.game_list_domain.models.PlatformUi

object GameListFactory {

    fun getGameListUi(page: Int): GameListModelUi {
        return GameListModelUi(
            next = "https://api.rawg.io/api/games?key=b93e15401f5e4b6ba8e982d50e192f75&page=2&page_size=20",
            previous = null,
            gameLights = listOf(
                GameLightUi(
                    id = 3498,
                    name = "Grand Theft Auto V",
                    picture = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg",
                    rating = 4.47,
                    platforms = listOf(
                        PlatformUi(name = "pc"), PlatformUi(name = "playstation"), PlatformUi(
                            name = "xbox"
                        )
                    ),
                    genreUis = listOf(GenreUi(name = "Action"), GenreUi(name = "Adventure"))
                ), GameLightUi(
                    id = 3328,
                    name = "The Witcher 3: Wild Hunt",
                    picture = "https://media.rawg.io/media/games/618/618c2031a07bbff6b4f611f10b6bcdbc.jpg",
                    rating = 4.67,
                    platforms = listOf(
                        PlatformUi(name = "pc"),
                        PlatformUi(name = "playstation"),
                        PlatformUi(name = "xbox"),
                        PlatformUi(
                            name = "nintendo"
                        )
                    ),
                    genreUis = listOf(
                        GenreUi(name = "Action"),
                        GenreUi(name = "Adventure"),
                        GenreUi(name = "RPG")
                    )
                ), GameLightUi(
                    id = 4200,
                    name = "Portal 2",
                    picture = "https://media.rawg.io/media/games/328/3283617cb7d75d67257fc58339188742.jpg",
                    rating = 4.61,
                    platforms = listOf(
                        PlatformUi(name = "pc"),
                        PlatformUi(name = "playstation"),
                        PlatformUi(name = "xbox"),
                        PlatformUi(
                            name = "mac"
                        ),
                        PlatformUi(name = "linux")
                    ),
                    genreUis = listOf(GenreUi(name = "Shooter"), GenreUi(name = "Puzzle"))
                ), GameLightUi(
                    id = 5286,
                    name = "Tomb Raider (2013)",
                    picture = "https://media.rawg.io/media/games/021/021c4e21a1824d2526f925eff6324653.jpg",
                    rating = 4.05,
                    platforms = listOf(
                        PlatformUi(name = "pc"),
                        PlatformUi(name = "playstation"),
                        PlatformUi(name = "xbox"),
                        PlatformUi(
                            name = "mac"
                        )
                    ),
                    genreUis = listOf(GenreUi(name = "Action"), GenreUi(name = "Adventure"))
                ), GameLightUi(
                    id = 4291,
                    name = "Counter - Strike: Global Offensive",
                    picture = "https://media.rawg.io/media/games/736/73619bd336c894d6941d926bfd563946.jpg",
                    rating = 3.57,
                    platforms = listOf(
                        PlatformUi(name = "pc"),
                        PlatformUi(name = "playstation"),
                        PlatformUi(name = "xbox")
                    ),
                    genreUis = listOf(GenreUi(name = "Action"), GenreUi(name = "Shooter"))
                ), GameLightUi(
                    id = 5679,
                    name = "The Elder Scrolls V : Skyrim",
                    picture = "https://media.rawg.io/media/games/7cf/7cfc9220b401b7a300e409e539c9afd5.jpg",
                    rating = 4.42,
                    platforms = listOf(
                        PlatformUi(name = "pc"),
                        PlatformUi(name = "playstation"),
                        PlatformUi(name = "xbox"),
                        PlatformUi(
                            name = "nintendo"
                        )
                    ),
                    genreUis = listOf(GenreUi(name = "Action"), GenreUi(name = "RPG"))
                ), GameLightUi(
                    id = 12020,
                    name = "Left4 Dead 2",
                    picture = "https://media.rawg.io/media/games/d58/d588947d4286e7b5e0e12e1bea7d9844.jpg",
                    rating = 4.08,
                    platforms = listOf(
                        PlatformUi(name = "pc"),
                        PlatformUi(name = "xbox"),
                        PlatformUi(name = "mac"),
                        PlatformUi(
                            name = "linux"
                        )
                    ),
                    genreUis = listOf(GenreUi(name = "Action"), GenreUi(name = "Shooter"))
                ), GameLightUi(
                    id = 13536,
                    name = "Portal",
                    picture = "https://media.rawg.io/media/games/7fa/7fa0b586293c5861ee32490e953a4996.jpg",
                    rating = 4.51,
                    platforms = listOf(
                        PlatformUi(name = "pc"),
                        PlatformUi(name = "playstation"),
                        PlatformUi(name = "xbox"),
                        PlatformUi(
                            name = "android"
                        ),
                        PlatformUi(name = "mac"),
                        PlatformUi(name = "linux"),
                        PlatformUi(name = "nintendo")
                    ),
                    genreUis = listOf(GenreUi(name = "Adventure"), GenreUi(name = "Puzzle"))
                ), GameLightUi(
                    id = 4062,
                    name = "BioShock Infinite",
                    picture = "https://media.rawg.io/media/games/fc1/fc1307a2774506b5bd65d7e8424664a7.jpg",
                    rating = 4.39,
                    platforms = listOf(
                        PlatformUi(name = "pc"),
                        PlatformUi(name = "playstation"),
                        PlatformUi(name = "xbox"),
                        PlatformUi(
                            name = "linux"
                        ),
                        PlatformUi(name = "nintendo")
                    ),
                    genreUis = listOf(GenreUi(name = "Action"), GenreUi(name = "Shooter"))
                ), GameLightUi(
                    id = 3439,
                    name = "Life is Strange",
                    picture = "https://media.rawg.io/media/games/562/562553814dd54e001a541e4ee83a591c.jpg",
                    rating = 4.11,
                    platforms = listOf(
                        PlatformUi(name = "pc"),
                        PlatformUi(name = "playstation"),
                        PlatformUi(name = "xbox"),
                        PlatformUi(
                            name = "ios"
                        ),
                        PlatformUi(name = "android"),
                        PlatformUi(name = "mac"),
                        PlatformUi(name = "linux")
                    ),
                    genreUis = listOf(GenreUi(name = "Adventure"))
                )
            )
        )
    }

    fun getGameListModel(page: Int): GameListModel {
        return GameListModel(
            next = "https://api.rawg.io/api/games?key=b93e15401f5e4b6ba8e982d50e192f75&page=2&page_size=20",
            previous = null,
            gameLights = listOf(
                GameLightModel(
                    id = 3498,
                    name = "Grand Theft Auto V",
                    picture = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg",
                    rating = 4.47,
                    platforms = listOf(
                        PlatformModel(name = "pc"),
                        PlatformModel(name = "playstation"),
                        PlatformModel(
                            name = "xbox"
                        )
                    ),
                    genre = listOf(GenreModel(name = "Action"), GenreModel(name = "Adventure"))
                ), GameLightModel(
                    id = 3328,
                    name = "The Witcher 3: Wild Hunt",
                    picture = "https://media.rawg.io/media/games/618/618c2031a07bbff6b4f611f10b6bcdbc.jpg",
                    rating = 4.67,
                    platforms = listOf(
                        PlatformModel(name = "pc"),
                        PlatformModel(name = "playstation"),
                        PlatformModel(name = "xbox"),
                        PlatformModel(
                            name = "nintendo"
                        )
                    ),
                    genre = listOf(
                        GenreModel(name = "Action"),
                        GenreModel(name = "Adventure"),
                        GenreModel(name = "RPG")
                    )
                ), GameLightModel(
                    id = 4200,
                    name = "Portal 2",
                    picture = "https://media.rawg.io/media/games/328/3283617cb7d75d67257fc58339188742.jpg",
                    rating = 4.61,
                    platforms = listOf(
                        PlatformModel(name = "pc"),
                        PlatformModel(name = "playstation"),
                        PlatformModel(name = "xbox"),
                        PlatformModel(
                            name = "mac"
                        ),
                        PlatformModel(name = "linux")
                    ),
                    genre = listOf(GenreModel(name = "Shooter"), GenreModel(name = "Puzzle"))
                ), GameLightModel(
                    id = 5286,
                    name = "Tomb Raider (2013)",
                    picture = "https://media.rawg.io/media/games/021/021c4e21a1824d2526f925eff6324653.jpg",
                    rating = 4.05,
                    platforms = listOf(
                        PlatformModel(name = "pc"),
                        PlatformModel(name = "playstation"),
                        PlatformModel(name = "xbox"),
                        PlatformModel(
                            name = "mac"
                        )
                    ),
                    genre = listOf(GenreModel(name = "Action"), GenreModel(name = "Adventure"))
                ), GameLightModel(
                    id = 4291,
                    name = "Counter - Strike: Global Offensive",
                    picture = "https://media.rawg.io/media/games/736/73619bd336c894d6941d926bfd563946.jpg",
                    rating = 3.57,
                    platforms = listOf(
                        PlatformModel(name = "pc"),
                        PlatformModel(name = "playstation"),
                        PlatformModel(name = "xbox")
                    ),
                    genre = listOf(GenreModel(name = "Action"), GenreModel(name = "Shooter"))
                ), GameLightModel(
                    id = 5679,
                    name = "The Elder Scrolls V : Skyrim",
                    picture = "https://media.rawg.io/media/games/7cf/7cfc9220b401b7a300e409e539c9afd5.jpg",
                    rating = 4.42,
                    platforms = listOf(
                        PlatformModel(name = "pc"),
                        PlatformModel(name = "playstation"),
                        PlatformModel(name = "xbox"),
                        PlatformModel(
                            name = "nintendo"
                        )
                    ),
                    genre = listOf(GenreModel(name = "Action"), GenreModel(name = "RPG"))
                ), GameLightModel(
                    id = 12020,
                    name = "Left4 Dead 2",
                    picture = "https://media.rawg.io/media/games/d58/d588947d4286e7b5e0e12e1bea7d9844.jpg",
                    rating = 4.08,
                    platforms = listOf(
                        PlatformModel(name = "pc"),
                        PlatformModel(name = "xbox"),
                        PlatformModel(name = "mac"),
                        PlatformModel(
                            name = "linux"
                        )
                    ),
                    genre = listOf(GenreModel(name = "Action"), GenreModel(name = "Shooter"))
                ), GameLightModel(
                    id = 13536,
                    name = "Portal",
                    picture = "https://media.rawg.io/media/games/7fa/7fa0b586293c5861ee32490e953a4996.jpg",
                    rating = 4.51,
                    platforms = listOf(
                        PlatformModel(name = "pc"),
                        PlatformModel(name = "playstation"),
                        PlatformModel(name = "xbox"),
                        PlatformModel(
                            name = "android"
                        ),
                        PlatformModel(name = "mac"),
                        PlatformModel(name = "linux"),
                        PlatformModel(name = "nintendo")
                    ),
                    genre = listOf(GenreModel(name = "Adventure"), GenreModel(name = "Puzzle"))
                ), GameLightModel(
                    id = 4062,
                    name = "BioShock Infinite",
                    picture = "https://media.rawg.io/media/games/fc1/fc1307a2774506b5bd65d7e8424664a7.jpg",
                    rating = 4.39,
                    platforms = listOf(
                        PlatformModel(name = "pc"),
                        PlatformModel(name = "playstation"),
                        PlatformModel(name = "xbox"),
                        PlatformModel(
                            name = "linux"
                        ),
                        PlatformModel(name = "nintendo")
                    ),
                    genre = listOf(GenreModel(name = "Action"), GenreModel(name = "Shooter"))
                ), GameLightModel(
                    id = 3439,
                    name = "Life is Strange",
                    picture = "https://media.rawg.io/media/games/562/562553814dd54e001a541e4ee83a591c.jpg",
                    rating = 4.11,
                    platforms = listOf(
                        PlatformModel(name = "pc"),
                        PlatformModel(name = "playstation"),
                        PlatformModel(name = "xbox"),
                        PlatformModel(
                            name = "ios"
                        ),
                        PlatformModel(name = "android"),
                        PlatformModel(name = "mac"),
                        PlatformModel(name = "linux")
                    ),
                    genre = listOf(GenreModel(name = "Adventure"))
                )
            )
        )
    }

    fun getEmptyGameListModel(page: Int): GameListModel {
        return GameListModel(
            next = null,
            previous = null,
            gameLights = emptyList()
        )
    }
}