package com.example.game_list_data.sources

import com.example.game_list_data.sources.implementations.GameListSourceImpl
import com.example.game_list_data.sources.models.GameListRemoteModel
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GameListSourceImplTest {

    private lateinit var gameListSource: GameListSourceImpl
    private val source: Source = mock()
    private val mockedResult: GameListRemoteModel = mock()

    private val page: Int = 0
    private val pageSize: Int = 20
    private val key: String = "b93e15401f5e4b6ba8e982d50e192f75"

    @Before
    fun setup() {
        runBlocking {
            gameListSource = GameListSourceImpl(source)
            whenever(
                source.getGameList(
                    page = page,
                    pageSize = pageSize,
                    key = key
                )
            ).thenReturn(mockedResult)
        }
    }

    @Test
    fun `should return correct value`() {
        runBlocking {
            assertThat(gameListSource.getGameList(page)).isEqualTo(mockedResult)
        }
    }
}