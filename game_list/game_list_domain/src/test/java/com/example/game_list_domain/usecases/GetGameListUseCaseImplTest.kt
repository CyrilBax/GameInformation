package com.example.game_list_domain.usecases

import com.example.game_list_domain.factories.GameListFactory
import com.example.game_list_domain.repositories.GameListRepository
import com.example.game_list_domain.usecases.implementations.GetGameListUseCaseImpl
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetGameListUseCaseImplTest {

    private lateinit var useCase: GetGameListUseCaseImpl
    private val repository: GameListRepository = mock()
    private val page: Int = 0

    @Before
    fun setup() {
        useCase = GetGameListUseCaseImpl(repository)
        runBlocking {
            whenever(repository.getGameList(page)).thenReturn(GameListFactory.getGameListUi(page))
        }
    }

    @Test
    fun shouldReturnCorrectValue() {
        runBlocking {
            assertThat(useCase.execute(page)).isEqualTo(GameListFactory.getGameListUi(page))
        }
    }
}