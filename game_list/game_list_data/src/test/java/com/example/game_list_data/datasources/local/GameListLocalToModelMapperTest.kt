package com.example.game_list_data.datasources.local

import com.example.commons.Mapper
import com.example.game_list_data.cache.models.GameListEntity
import com.example.game_list_data.datasources.local.mappers.GameListLocalToModelMapper
import com.example.game_list_data.datasources.models.GameListModel
import com.example.game_list_data.factories.GameListFactory
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GameListLocalToModelMapperTest {

    private val mapper: Mapper<GameListEntity, GameListModel> = GameListLocalToModelMapper()
    private val page: Int = 0

    @Test
    fun `should return correct value`() {
        runBlocking {
            assertThat(mapper.mapTo(GameListFactory.getGameListEntity(page))).isEqualTo(GameListFactory.getGameListModel(page))
        }
    }
}