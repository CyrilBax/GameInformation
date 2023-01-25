package com.example.game_page_data.factories

import com.example.game_page_data.cache.models.GamePageEntity
import com.example.game_page_data.cache.models.GenreEntity
import com.example.game_page_data.cache.models.PlatformEntity
import com.example.game_page_data.cache.models.TagEntity
import com.example.game_page_data.datasources.models.GamePageModel
import com.example.game_page_data.datasources.models.GenreModel
import com.example.game_page_data.datasources.models.PlatformModel
import com.example.game_page_data.datasources.models.TagModel
import com.example.game_page_data.services.models.*

object GamePageFactory {

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

    fun getGamePageEntity(): GamePageEntity {
        return GamePageEntity(
            id = "3328",
            name = "The Witcher 3: Wild Hunt ",
            description = "<p> The third game in a series, it holds nothing back from the player . Open world adventures of the renowned monster slayer Geralt of Rivia are now even on a larger scale.Following the source material more accurately,this time Geralt is trying to find the child of the prophecy, Ciriwhile making a quick coin from various contracts on the side . Great attention to the world building above all creates an immersive story, where your decisions will shape the world around you.< / p >< p > CD Project Red are infamous for the amount of work they put into their games, and it shows, because aside from classic third - person action RPG base game they provided2 massive DLCs with unique questlines and16 smaller DLCs, containing extra quests and items.< / p > < p > Players praise the gamefor its atmosphere and a wide open world that finds the balance between fantasy elements and realistic and believable mechanics, and the game deserved numerous awards for every aspect of the game, from music to direction . </p>",
            pictureUrl = "https://media.rawg.io/media/games/328/3283617cb7d75d67257fc58339188742.jpg",
            rating = 4.67,
            reditLink = "https://www.reddit.com/r/thewitcher3/",
            reditDescription = "A subreddit for veterans and new fans alike of The Witcher 3: Wild Hunt as well as for other Witcher games and the franchise in general. Everyone is welcome.",
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
            ),
            tags = listOf(
                TagEntity(name = "Singleplayer"),
                TagEntity(name = "Atmospheric"),
                TagEntity(name = "Full controller support"),
                TagEntity(
                    name = "Great Soundtrack"
                ),
                TagEntity(name = "RPG"),
                TagEntity(name = "Story Rich"),
                TagEntity(name = "Open World"),
                TagEntity(
                    name = "Third Person"
                ),
                TagEntity(
                    name = "Fantasy"
                ),
                TagEntity(name = "Sandbox"),
                TagEntity(name = "Action RPG"),
                TagEntity(name = "Dark"),
                TagEntity(name = "Nudity"),
                TagEntity(
                    name = "controller support"
                ),
                TagEntity(name = "Choices Matter"),
                TagEntity(name = "Mature"),
                TagEntity(name = "Dark Fantasy"),
                TagEntity(
                    name = "Medieval"
                ),
                TagEntity(name = "Magic"),
                TagEntity(name = "Multiple Endings")
            )
        )
    }

    fun getGamePageModelRemote(): GamePageModelRemote {
        return GamePageModelRemote(
            id = "3328",
            name = "The Witcher 3: Wild Hunt ",
            description = "<p> The third game in a series, it holds nothing back from the player . Open world adventures of the renowned monster slayer Geralt of Rivia are now even on a larger scale.Following the source material more accurately,this time Geralt is trying to find the child of the prophecy, Ciriwhile making a quick coin from various contracts on the side . Great attention to the world building above all creates an immersive story, where your decisions will shape the world around you.< / p >< p > CD Project Red are infamous for the amount of work they put into their games, and it shows, because aside from classic third - person action RPG base game they provided2 massive DLCs with unique questlines and16 smaller DLCs, containing extra quests and items.< / p > < p > Players praise the gamefor its atmosphere and a wide open world that finds the balance between fantasy elements and realistic and believable mechanics, and the game deserved numerous awards for every aspect of the game, from music to direction . </p>",
            backgroundImage = "https://media.rawg.io/media/games/328/3283617cb7d75d67257fc58339188742.jpg",
            rating = 4.67,
            reditLink = "https://www.reddit.com/r/thewitcher3/",
            reditDescription = "A subreddit for veterans and new fans alike of The Witcher 3: Wild Hunt as well as for other Witcher games and the franchise in general. Everyone is welcome.",
            platforms = listOf(
                ParentPlatform(Platform(slug = "pc")),
                ParentPlatform(Platform(slug = "playstation")),
                ParentPlatform(Platform(slug = "xbox")),
                ParentPlatform(Platform(slug = "nintendo"))
            ),
            genres = listOf(
                GenreRemote(name = "Action"),
                GenreRemote(name = "Adventure"),
                GenreRemote(name = "RPG")
            ),
            tags = listOf(
                TagRemote(name = "Singleplayer"),
                TagRemote(name = "Atmospheric"),
                TagRemote(name = "Full controller support"),
                TagRemote(
                    name = "Great Soundtrack"
                ),
                TagRemote(name = "RPG"),
                TagRemote(name = "Story Rich"),
                TagRemote(name = "Open World"),
                TagRemote(
                    name = "Third Person"
                ),
                TagRemote(
                    name = "Fantasy"
                ),
                TagRemote(name = "Sandbox"),
                TagRemote(name = "Action RPG"),
                TagRemote(name = "Dark"),
                TagRemote(name = "Nudity"),
                TagRemote(
                    name = "controller support"
                ),
                TagRemote(name = "Choices Matter"),
                TagRemote(name = "Mature"),
                TagRemote(name = "Dark Fantasy"),
                TagRemote(
                    name = "Medieval"
                ),
                TagRemote(name = "Magic"),
                TagRemote(name = "Multiple Endings")
            )
        )
    }
}