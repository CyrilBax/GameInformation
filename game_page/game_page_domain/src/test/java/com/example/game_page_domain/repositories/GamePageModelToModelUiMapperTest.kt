package com.example.game_page_domain.repositories

import com.example.commons.Mapper
import com.example.game_page_data.datasources.models.GamePageModel
import com.example.game_page_domain.factories.GamePageFactory
import com.example.game_page_domain.models.GamePageModelUi
import com.example.game_page_domain.repositories.mapper.GamePageModelToModelUiMapper
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class GamePageModelToModelUiMapperTest {

    private val mapper: Mapper<GamePageModel, GamePageModelUi> = GamePageModelToModelUiMapper()

    @Test
    fun `should return correct value`() {
        assertThat(mapper.mapTo(GamePageFactory.getGamePageModel())).isEqualTo(GamePageFactory.getGamePageModelUi())
    }

}