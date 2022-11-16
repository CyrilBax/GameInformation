package com.example.game_list_data.datasources.remote

import android.content.Context
import com.example.commons.Mapper
import com.example.game_list_data.datasources.models.GameListModel
import com.example.game_list_data.datasources.remote.implementations.GameListRemoteDataSourceImpl
import com.example.game_list_data.sources.GameListSource
import com.example.game_list_data.sources.models.GameListRemoteModel
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GameListRemoteDataSourceImplTest {

    private lateinit var gameListRemoteDataSource: GameListRemoteDataSourceImpl
    private val service: GameListSource = mock()
    private val mapper: Mapper<GameListRemoteModel, GameListModel> = mock()
    private val context: Context = mock()

    private val page: Int = 0
    private val mockedModelResult: GameListModel = mock()
    private val mockedRemoteModelResult: GameListRemoteModel = mock()

    @Before
    fun setup() {
        runBlocking {
            gameListRemoteDataSource = GameListRemoteDataSourceImpl(service, mapper, context)
            whenever(service.getGameList(page)).thenReturn(mockedRemoteModelResult)
            whenever(mapper.mapTo(mockedRemoteModelResult)).thenReturn(mockedModelResult)
        }
    }

    @Test
    fun `should return correct value`() {
        runBlocking {
            assertThat(gameListRemoteDataSource.getGameList(page)).isEqualTo(mockedModelResult)
        }
    }
}