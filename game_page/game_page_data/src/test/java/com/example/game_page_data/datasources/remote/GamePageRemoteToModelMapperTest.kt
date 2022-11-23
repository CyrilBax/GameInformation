package com.example.game_page_data.datasources.remote

import com.example.commons.Mapper
import com.example.game_page_data.datasources.models.GamePageModel
import com.example.game_page_data.datasources.remote.mappers.GamePageRemoteToModelMapper
import com.example.game_page_data.factories.GamePageFactory
import com.example.game_page_data.services.models.GamePageModelRemote
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class GamePageRemoteToModelMapperTest {

    private val mapper: Mapper<GamePageModelRemote, GamePageModel> = GamePageRemoteToModelMapper()

    @Test
    fun `should return correct value`() {
        assertThat(mapper.mapTo(GamePageFactory.getGamePageModelRemote())).isEqualTo(GamePageFactory.getGamePageModel())
    }
}