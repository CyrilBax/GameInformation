package com.example.game_page_data.services

import com.example.game_page_data.factories.GamePageFactory
import com.example.game_page_data.services.implementations.GamePageServiceImpl
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GamePageServiceImplTest {
    private lateinit var gameService: GamePageServiceImpl
    private val service: Service = mock()

    private val gameId: String = "1"

    @Before
    fun setup() {
        gameService = GamePageServiceImpl(service)
        runBlocking {
            whenever(service.getGamePage(gameId)).thenReturn(GamePageFactory.getGamePageModelRemote())
        }
    }

    @Test
    fun `should return correct value`() {
        runBlocking {
            assertThat(gameService.getGamePage(gameId)).isEqualTo(GamePageFactory.getGamePageModelRemote())
        }
    }
}