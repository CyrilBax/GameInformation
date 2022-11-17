package com.example.game_list_data.datasources.local

import com.example.commons.Mapper
import com.example.game_list_data.cache.GameListDataBase
import com.example.game_list_data.cache.models.GameListEntity
import com.example.game_list_data.datasources.local.implementations.GameListLocalDataSourceImpl
import com.example.game_list_data.datasources.models.GameListModel
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GameListLocalDataSourceImplTest {

    private lateinit var gameListLocalDataSource: GameListLocalDataSourceImpl
    private var gameListDataBase: GameListDataBase = mock()
    private val entityToModelMapper: Mapper<GameListEntity, GameListModel> = mock()
    private val modelToEntityMapper: Mapper<GameListModel, GameListEntity> = mock()

    private val page: Int = 0
    private val mockedEntity: GameListEntity = mock()
    private val mockedModel: GameListModel = mock()

    @Before
    fun setup() {
        runBlocking {
            gameListLocalDataSource = GameListLocalDataSourceImpl(
                gameListDataBase,
                entityToModelMapper,
                modelToEntityMapper
            )
            whenever(entityToModelMapper.mapTo(mockedEntity)).thenReturn(mockedModel)
            whenever(modelToEntityMapper.mapTo(mockedModel)).thenReturn(mockedEntity)
            whenever(gameListDataBase.getGameListDao().getGameListPage(page)).thenReturn(
                mockedEntity
            )
        }
    }

    // region getGameList
    @Test
    fun `should return correct value`() {
        runBlocking {
            assertThat(gameListLocalDataSource.getGameList(page)).isEqualTo(mockedModel)
            verify(gameListDataBase.getGameListDao(), times(1)).getGameListPage(page)
        }
    }
    // endregion

    // region saveGameList
    @Test
    fun `should save game list`() {
        runBlocking {
            gameListLocalDataSource.saveGameList(mockedModel)
            verify(gameListDataBase.getGameListDao(), times(1)).saveGameList(mockedEntity)
        }
    }
    // endregion

}