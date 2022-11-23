package com.example.game_page_data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.game_page_data.cache.models.GamePageEntity
import com.example.game_page_data.cache.models.GenreEntity
import com.example.game_page_data.cache.models.PlatformEntity
import com.example.game_page_data.cache.models.TagEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

@Database(entities = [GamePageEntity::class], version = 1, exportSchema = false)
@TypeConverters(PlatformEntityConverter::class)
abstract class GamePageDataBase : RoomDatabase() {

    abstract fun getGamePageDao(): GamePageDAO

    companion object {
        const val DATA_BASE_NAME = "GAME_PAGE_DATA_BASE"
    }
}

internal class PlatformEntityConverter {
    var gson = Gson()

    @TypeConverter
    fun toListPlatformEntity(from: String?): List<PlatformEntity> {
        if (from == null) return emptyList()
        val type: Type = object : TypeToken<List<PlatformEntity>>() {}.type

        return gson.fromJson(from, type)
    }

    @TypeConverter
    fun fromListPlatformEntity(from: List<PlatformEntity>): String {
        return gson.toJson(from)
    }

    @TypeConverter
    fun toListGenreEntity(from: String?): List<GenreEntity> {
        if (from == null) return emptyList()
        val type: Type = object : TypeToken<List<GenreEntity>>() {}.type

        return gson.fromJson(from, type)
    }

    @TypeConverter
    fun fromListGenreEntity(from: List<GenreEntity>): String {
        return gson.toJson(from)
    }

    @TypeConverter
    fun toListTagEntity(from: String?): List<TagEntity> {
        if (from == null) return emptyList()
        val type: Type = object : TypeToken<List<TagEntity>>() {}.type

        return gson.fromJson(from, type)
    }

    @TypeConverter
    fun fromListTagEntity(from: List<TagEntity>): String {
        return gson.toJson(from)
    }
}
