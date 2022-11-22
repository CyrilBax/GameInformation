package com.example.game_page_data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.game_page_data.cache.models.GamePageEntity

@Dao
interface GamePageDAO {

    @Query("SELECT * FROM gamepageentity WHERE id IS (:gameId)")
    fun getGamePage(gameId: String): GamePageEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveGamePage(gamePage: GamePageEntity)
}