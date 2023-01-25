package com.example.game_page_domain.factories

import com.example.game_page_data.datasources.models.GamePageModel
import com.example.game_page_data.datasources.models.GenreModel
import com.example.game_page_data.datasources.models.PlatformModel
import com.example.game_page_data.datasources.models.TagModel
import com.example.game_page_domain.models.GamePageModelUi
import com.example.game_page_domain.models.GenreUi
import com.example.game_page_domain.models.PlatformUi
import com.example.game_page_domain.models.TagUi

object GamePageFactory {

    fun getGamePageModelUi(): GamePageModelUi {
        return GamePageModelUi(
            id = "3328",
            name = "The Witcher 3: Wild Hunt ",
            description = "<p> The third game in a series, it holds nothing back from the player . Open world adventures of the renowned monster slayer Geralt of Rivia are now even on a larger scale.Following the source material more accurately,this time Geralt is trying to find the child of the prophecy, Ciriwhile making a quick coin from various contracts on the side . Great attention to the world building above all creates an immersive story, where your decisions will shape the world around you.< / p >< p > CD Project Red are infamous for the amount of work they put into their games, and it shows, because aside from classic third - person action RPG base game they provided2 massive DLCs with unique questlines and16 smaller DLCs, containing extra quests and items.< / p > < p > Players praise the gamefor its atmosphere and a wide open world that finds the balance between fantasy elements and realistic and believable mechanics, and the game deserved numerous awards for every aspect of the game, from music to direction . </p>",
            pictureUrl = "https://media.rawg.io/media/games/328/3283617cb7d75d67257fc58339188742.jpg",
            rating = 4.67,
            reditLink = "https://www.reddit.com/r/thewitcher3/",
            reditDescription = "A subreddit for veterans and new fans alike of The Witcher 3: Wild Hunt as well as for other Witcher games and the franchise in general. Everyone is welcome.",
            platformUis = listOf(
                PlatformUi(name = "pc"),
                PlatformUi(name = "playstation"),
                PlatformUi(name = "xbox"),
                PlatformUi(
                    name = "nintendo"
                )
            ),
            genres = listOf(
                GenreUi(name = "Action"),
                GenreUi(name = "Adventure"),
                GenreUi(name = "RPG")
            ),
            tags = listOf(
                TagUi(name = "Singleplayer"),
                TagUi(name = "Atmospheric"),
                TagUi(name = "Full controller support"),
                TagUi(
                    name = "Great Soundtrack"
                ),
                TagUi(name = "RPG"),
                TagUi(name = "Story Rich"),
                TagUi(name = "Open World"),
                TagUi(
                    name = "Third Person"
                ),
                TagUi(
                    name = "Fantasy"
                ),
                TagUi(name = "Sandbox"),
                TagUi(name = "Action RPG"),
                TagUi(name = "Dark"),
                TagUi(name = "Nudity"),
                TagUi(
                    name = "controller support"
                ),
                TagUi(name = "Choices Matter"),
                TagUi(name = "Mature"),
                TagUi(name = "Dark Fantasy"),
                TagUi(
                    name = "Medieval"
                ),
                TagUi(name = "Magic"),
                TagUi(name = "Multiple Endings")
            )
        )
    }

    fun getGamePageModel(): GamePageModel {
        return GamePageModel(
            id = "3328",
            name = "The Witcher 3: Wild Hunt ",
            description = "<p> The third game in a series, it holds nothing back from the player . Open world adventures of the renowned monster slayer Geralt of Rivia are now even on a larger scale.Following the source material more accurately,this time Geralt is trying to find the child of the prophecy, Ciriwhile making a quick coin from various contracts on the side . Great attention to the world building above all creates an immersive story, where your decisions will shape the world around you.< / p >< p > CD Project Red are infamous for the amount of work they put into their games, and it shows, because aside from classic third - person action RPG base game they provided2 massive DLCs with unique questlines and16 smaller DLCs, containing extra quests and items.< / p > < p > Players praise the gamefor its atmosphere and a wide open world that finds the balance between fantasy elements and realistic and believable mechanics, and the game deserved numerous awards for every aspect of the game, from music to direction . </p>",
            pictureUrl = "https://media.rawg.io/media/games/328/3283617cb7d75d67257fc58339188742.jpg",
            rating = 4.67,
            reditLink = "https://www.reddit.com/r/thewitcher3/",
            reditDescription = "A subreddit for veterans and new fans alike of The Witcher 3: Wild Hunt as well as for other Witcher games and the franchise in general. Everyone is welcome.",
            platforms = listOf(
                PlatformModel(name = "pc"),
                PlatformModel(name = "playstation"),
                PlatformModel(name = "xbox"),
                PlatformModel(
                    name = "nintendo"
                )
            ),
            genres = listOf(
                GenreModel(name = "Action"),
                GenreModel(name = "Adventure"),
                GenreModel(name = "RPG")
            ),
            tags = listOf(
                TagModel(name = "Singleplayer"),
                TagModel(name = "Atmospheric"),
                TagModel(name = "Full controller support"),
                TagModel(
                    name = "Great Soundtrack"
                ),
                TagModel(name = "RPG"),
                TagModel(name = "Story Rich"),
                TagModel(name = "Open World"),
                TagModel(
                    name = "Third Person"
                ),
                TagModel(
                    name = "Fantasy"
                ),
                TagModel(name = "Sandbox"),
                TagModel(name = "Action RPG"),
                TagModel(name = "Dark"),
                TagModel(name = "Nudity"),
                TagModel(
                    name = "controller support"
                ),
                TagModel(name = "Choices Matter"),
                TagModel(name = "Mature"),
                TagModel(name = "Dark Fantasy"),
                TagModel(
                    name = "Medieval"
                ),
                TagModel(name = "Magic"),
                TagModel(name = "Multiple Endings")
            )
        )
    }
}