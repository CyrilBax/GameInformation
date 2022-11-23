package com.example.game_page_domain.usecases

import com.example.game_page_domain.factories.GamePageFactory
import com.example.game_page_domain.repositories.GamePageRepository
import com.example.game_page_domain.usecases.implementations.GetGamePageUseCaseImpl
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetGamePageUseCaseImplTest {

    private lateinit var useCase: GetGamePageUseCaseImpl
    private val repository: GamePageRepository = mock()

    private val gameId: String = "1"

    @Before
    fun setup() {
        useCase = GetGamePageUseCaseImpl(repository)
        runBlocking {
            whenever(
                repository.getGamePage(gameId)
            ).thenReturn(GamePageFactory.getGamePageModelUi())
        }
    }

    @Test
    fun `should return correct value`() {
        runBlocking {
            assertThat(useCase.execute(gameId)).isEqualTo(GamePageFactory.getGamePageModelUi())
            verify(repository, times(1)).getGamePage(gameId)
        }
    }
}