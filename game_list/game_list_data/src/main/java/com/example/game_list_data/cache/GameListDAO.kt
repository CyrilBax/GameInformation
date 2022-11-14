package com.example.game_list_data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.game_list_data.cache.models.GameListEntity

@Dao
interface GameListDAO {

    @Query("SELECT * FROM gamelistentity WHERE page IS (:page)")
    fun getGameListPage(page: Int): GameListEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveGameList(gameList: GameListEntity)
}