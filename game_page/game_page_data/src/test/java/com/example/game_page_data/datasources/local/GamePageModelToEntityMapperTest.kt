package com.example.game_page_data.datasources.local

import com.example.commons.Mapper
import com.example.game_page_data.cache.models.GamePageEntity
import com.example.game_page_data.datasources.local.mapper.GamePageModelToEntityMapper
import com.example.game_page_data.datasources.models.GamePageModel
import com.example.game_page_data.factories.GamePageFactory
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class GamePageModelToEntityMapperTest {

    private val mapper: Mapper<GamePageModel, GamePageEntity> = GamePageModelToEntityMapper()

    @Test
    fun `should return correct value`() {
        assertThat(mapper.mapTo(GamePageFactory.getGamePageModel())).isEqualTo(GamePageFactory.getGamePageEntity())
    }
}