package com.example.game_page_data.datasources.local

import com.example.commons.Mapper
import com.example.game_page_data.cache.GamePageDataBase
import com.example.game_page_data.cache.models.GamePageEntity
import com.example.game_page_data.datasources.local.implementations.GamePageLocalDataSourceImpl
import com.example.game_page_data.datasources.models.GamePageModel
import com.example.game_page_data.factories.GamePageFactory
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GamePageLocalDataSourceImplTest {

    private lateinit var dataSource: GamePageLocalDataSourceImpl
    private val dataBase : GamePageDataBase = mock()
    private val entityToModelMapper: Mapper<GamePageEntity, GamePageModel> = mock()
    private val modelToEntityMapper: Mapper<GamePageModel, GamePageEntity> = mock()

    private val gameId: String = "1"

    @Before
    fun setup() {
        dataSource = GamePageLocalDataSourceImpl(dataBase, entityToModelMapper, modelToEntityMapper)
        runBlocking {
            whenever(dataBase.getGamePageDao().getGamePage(gameId)).thenReturn(GamePageFactory.getGamePageEntity())
            whenever(entityToModelMapper.mapTo(GamePageFactory.getGamePageEntity())).thenReturn(GamePageFactory.getGamePageModel())
            whenever(modelToEntityMapper.mapTo(GamePageFactory.getGamePageModel())).thenReturn(GamePageFactory.getGamePageEntity())
        }
    }

    @Test
    fun `should return correct value`() {
        runBlocking {
            assertThat(dataSource.getGamePage(gameId)).isEqualTo(GamePageFactory.getGamePageModel())
        }
    }

    @Test
    fun `should save game page`() {
        runBlocking {
            dataSource.saveGamePage(GamePageFactory.getGamePageModel())
            verify(dataBase.getGamePageDao(), times(1)).saveGamePage(GamePageFactory.getGamePageEntity())
        }
    }
}