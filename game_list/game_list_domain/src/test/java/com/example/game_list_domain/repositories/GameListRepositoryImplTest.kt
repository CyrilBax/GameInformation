package com.example.game_list_domain.repositories

import com.example.commons.Mapper
import com.example.game_list_data.datasources.local.GameListLocalDataSource
import com.example.game_list_data.datasources.models.GameListModel
import com.example.game_list_data.datasources.remote.GameListRemoteDataSource
import com.example.game_list_domain.factories.GameListFactory
import com.example.game_list_domain.models.GameListModelUi
import com.example.game_list_domain.repositories.implementations.GameListRepositoryImpl
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GameListRepositoryImplTest {

    private lateinit var repository: GameListRepositoryImpl
    private val localDataSource: GameListLocalDataSource = mock()
    private val remoteDataSource: GameListRemoteDataSource = mock()
    private val mapper: Mapper<GameListModel, GameListModelUi> = mock()
    private val page: Int = 0

    @Before
    fun setup() {
        repository = GameListRepositoryImpl(localDataSource, remoteDataSource, mapper)
        runBlocking {
            whenever(remoteDataSource.getGameList(page)).thenReturn(
                GameListFactory.getGameListModel(
                    page
                )
            )
            whenever(mapper.mapTo(GameListFactory.getGameListModel(page))).thenReturn(
                GameListFactory.getGameListUi(page)
            )
        }
    }

    @Test
    fun `should return correct value from remote`() {
        runBlocking {
            whenever(remoteDataSource.isOnline()).thenReturn(true)
            whenever(localDataSource.getGameList(page)).thenReturn(
                GameListFactory.getEmptyGameListModel(
                    page
                )
            )
            assertThat(repository.getGameList(page)).isEqualTo(GameListFactory.getGameListUi(page))
            verify(remoteDataSource, times(1)).getGameList(page)
            verify(remoteDataSource, times(1)).isOnline()
        }
    }

    @Test
    fun `should return correct value from local`() {
        runBlocking {
            whenever(localDataSource.getGameList(page)).thenReturn(
                GameListFactory.getGameListModel(
                    page
                )
            )
            assertThat(repository.getGameList(page)).isEqualTo(GameListFactory.getGameListUi(page))
            verify(remoteDataSource, times(0))
        }
    }

    @Test
    fun `should call remote data source when no data retrieve from local`() {
        runBlocking {
            whenever(remoteDataSource.isOnline()).thenReturn(true)
            whenever(localDataSource.getGameList(page)).thenReturn(
                GameListFactory.getEmptyGameListModel(
                    page
                )
            )
            repository.getGameList(page)
            verify(remoteDataSource, times(1)).getGameList(page)
            verify(remoteDataSource, times(1)).isOnline()
        }
    }

    @Test
    fun `should not call remote data source when data is retrieve from local`() {
        runBlocking {
            whenever(localDataSource.getGameList(page)).thenReturn(
                GameListFactory.getGameListModel(
                    page
                )
            )
            repository.getGameList(page)
            verify(localDataSource, times(1)).getGameList(page)
            verify(remoteDataSource, times(0))
        }
    }

    @Test
    fun `should save game list when retrieve from remote data source`() {
        runBlocking {
            whenever(localDataSource.getGameList(page)).thenReturn(
                GameListFactory.getEmptyGameListModel(
                    page
                )
            )
            whenever(remoteDataSource.isOnline()).thenReturn(true)
            repository.getGameList(page)
            verify(localDataSource, times(1)).saveGameList(GameListFactory.getGameListModel(page))
        }
    }
}