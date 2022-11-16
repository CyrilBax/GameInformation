package com.example.game_list_data.cache

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.game_list_data.cache.models.GameListEntity
import com.example.game_list_data.factories.GameListFactory
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class GameListDataBaseTest {

    private lateinit var gameListDataBase: GameListDataBase
    private lateinit var gameListDAO: GameListDAO

    private val page: Int = 1

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        gameListDataBase = Room.inMemoryDatabaseBuilder(
            context,
            GameListDataBase::class.java
        ).build()
        gameListDAO = gameListDataBase.getGameListDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDatabase() {
        gameListDataBase.close()
    }

    @Test
    fun shouldSaveAndReadGameList() {
        gameListDAO.saveGameList(GameListFactory.getGameListEntity(page))

        val result = gameListDAO.getGameListPage(page).toString()
        val expected = GameListFactory.getGameListEntity(page).toString()

        assertThat(result, equals(expected))
    }
}