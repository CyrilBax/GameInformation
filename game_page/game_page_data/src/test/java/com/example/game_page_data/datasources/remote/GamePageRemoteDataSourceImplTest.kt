package com.example.game_page_data.datasources.remote

import android.content.Context
import com.example.commons.Mapper
import com.example.game_page_data.datasources.models.GamePageModel
import com.example.game_page_data.datasources.remote.implementations.GamePageRemoteDataSourceImpl
import com.example.game_page_data.factories.GamePageFactory
import com.example.game_page_data.services.GamePageService
import com.example.game_page_data.services.models.GamePageModelRemote
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GamePageRemoteDataSourceImplTest {

    private lateinit var dataSource: GamePageRemoteDataSourceImpl
    private val service: GamePageService = mock()
    private val mapper: Mapper<GamePageModelRemote, GamePageModel> = mock()
    private val context: Context = mock()
    private val gameId: String = "1"

    @Before
    fun setup() {
        dataSource = GamePageRemoteDataSourceImpl(service, mapper, context)
        runBlocking {
            whenever(mapper.mapTo(GamePageFactory.getGamePageModelRemote())).thenReturn(
                GamePageFactory.getGamePageModel()
            )
            whenever(service.getGamePage(gameId)).thenReturn(GamePageFactory.getGamePageModelRemote())
        }
    }

    @Test
    fun `should return correct value`() {
        runBlocking {
            assertThat(dataSource.getGamePage(gameId)).isEqualTo(GamePageFactory.getGamePageModel())
            verify(service, times(1)).getGamePage(gameId)
        }
    }

}