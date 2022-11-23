package com.example.game_page_domain.repositories

import com.example.commons.Mapper
import com.example.game_page_data.datasources.local.GamePageLocalDataSource
import com.example.game_page_data.datasources.models.GamePageModel
import com.example.game_page_data.datasources.remote.GamePageRemoteDataSource
import com.example.game_page_domain.factories.GamePageFactory
import com.example.game_page_domain.models.GamePageModelUi
import com.example.game_page_domain.repositories.implementations.GamePageRepositoryImpl
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GamePageRepositoryImplTest {

    private lateinit var repository: GamePageRepositoryImpl
    private val localDataSource: GamePageLocalDataSource = mock()
    private val remoteDataSource: GamePageRemoteDataSource = mock()
    private val mapper: Mapper<GamePageModel, GamePageModelUi> = mock()

    private val gameId: String = "1"

    @Before
    fun setup() {
        repository = GamePageRepositoryImpl(localDataSource, remoteDataSource, mapper)
        runBlocking {
            whenever(remoteDataSource.getGamePage(gameId)).thenReturn(GamePageFactory.getGamePageModel())
            whenever(mapper.mapTo(GamePageFactory.getGamePageModel())).thenReturn(GamePageFactory.getGamePageModelUi())
        }
    }

    @Test
    fun `should call remote datasource when not data retrieve from local`() {
        runBlocking {
            whenever(localDataSource.getGamePage(gameId)).thenReturn(null)
            whenever(remoteDataSource.isOnline()).thenReturn(true)
            repository.getGamePage(gameId)
            verify(localDataSource, times(1)).getGamePage(gameId)
            verify(remoteDataSource, times(1)).getGamePage(gameId)
            verify(remoteDataSource, times(1)).isOnline()
        }
    }

    @Test
    fun `should not call remote data source when data is retrieve from local`() {
        runBlocking {
            whenever(localDataSource.getGamePage(gameId)).thenReturn(GamePageFactory.getGamePageModel())
            repository.getGamePage(gameId)
            verify(localDataSource, times(1)).getGamePage(gameId)
            verify(remoteDataSource, times(0)).getGamePage(gameId)
        }
    }

    @Test
    fun `should return correct value from local`() {
        runBlocking {
            whenever(localDataSource.getGamePage(gameId)).thenReturn(GamePageFactory.getGamePageModel())
            assertThat(repository.getGamePage(gameId)).isEqualTo(GamePageFactory.getGamePageModelUi())
        }
    }

    @Test
    fun `should return correct value from remote`() {
        runBlocking {
            whenever(localDataSource.getGamePage(gameId)).thenReturn(null)
            whenever(remoteDataSource.isOnline()).thenReturn(true)
            assertThat(repository.getGamePage(gameId)).isEqualTo(GamePageFactory.getGamePageModelUi())
        }
    }

}