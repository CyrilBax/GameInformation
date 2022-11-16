package com.example.game_list_data.datasources.remote

import com.example.commons.Mapper
import com.example.game_list_data.datasources.models.GameListModel
import com.example.game_list_data.datasources.remote.mappers.GameListRemoteToModelMapper
import com.example.game_list_data.factories.GameListFactory
import com.example.game_list_data.sources.models.GameListRemoteModel
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class GameListRemoteToModelMapperTest {

    private val mapper: Mapper<GameListRemoteModel, GameListModel> = GameListRemoteToModelMapper()
    private val page: Int = 0

    @Test
    fun `should return correct value`() {
        assertThat(mapper.mapTo(GameListFactory.getGameListRemoteModel(page))).isEqualTo(GameListFactory.getGameListModel(page))
    }
}