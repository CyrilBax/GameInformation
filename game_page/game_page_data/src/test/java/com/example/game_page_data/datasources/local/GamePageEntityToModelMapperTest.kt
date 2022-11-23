package com.example.game_page_data.datasources.local

import com.example.commons.Mapper
import com.example.game_page_data.cache.models.GamePageEntity
import com.example.game_page_data.datasources.local.mapper.GamePageEntityToModelMapper
import com.example.game_page_data.datasources.models.GamePageModel
import com.example.game_page_data.factories.GamePageFactory
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class GamePageEntityToModelMapperTest {

    private val mapper: Mapper<GamePageEntity, GamePageModel> = GamePageEntityToModelMapper()

    @Test
    fun `should return correct value`() {
        assertThat(mapper.mapTo(GamePageFactory.getGamePageEntity())).isEqualTo(GamePageFactory.getGamePageModel())
    }
}