package com.example.game_list_data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.game_list_data.cache.models.GameLightEntity
import com.example.game_list_data.cache.models.GameListEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

@Database(entities = [GameListEntity::class], version = 1, exportSchema = false)
@TypeConverters(GameLightConverter::class)
abstract class GameListDataBase : RoomDatabase() {

    abstract fun getGameListDao(): GameListDAO

    companion object {
        const val DATA_BASE_NAME = "GAME_LIST"
    }
}

internal class GameLightConverter {
    var gson = Gson()

    @TypeConverter
    fun toList(from: String?): List<GameLightEntity> {
        if (from == null) return emptyList()
        val type: Type = object : TypeToken<List<GameLightEntity>>() {}.type

        return gson.fromJson(from, type)
    }

    @TypeConverter
    fun fromList(from: List<GameLightEntity>): String {
        return gson.toJson(from)
    }
}