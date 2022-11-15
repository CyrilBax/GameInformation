package com.example.game_list_domain.mappers

import com.example.game_list_domain.factories.GameListFactory
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class GameListMapperTest {

    private val mapper = GameListMapper()
    private val page: Int = 0

    @Test
    fun `should return correct value`() {
        assertThat(mapper.mapTo(GameListFactory.getGameListModel(page))).isEqualTo(
            GameListFactory.getGameListUi(
                page
            )
        )
    }
}