package com.example.game_list_data.datasources.local

import com.example.commons.Mapper
import com.example.game_list_data.cache.models.GameListEntity
import com.example.game_list_data.datasources.local.mappers.GameListModelToLocalMapper
import com.example.game_list_data.datasources.models.GameListModel
import com.example.game_list_data.factories.GameListFactory
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class GameListModelToLocalMapperTest {

    private val mapper: Mapper<GameListModel, GameListEntity> = GameListModelToLocalMapper()
    private val page: Int = 1

    @Test
    fun `should return correct value`() {
        assertThat(mapper.mapTo(GameListFactory.getGameListModel(page))).isEqualTo(GameListFactory.getGameListEntity(page))
    }
}