package com.example.game_list_data.cache.profiles

import android.content.Context
import androidx.room.Room
import com.example.game_list_data.cache.GameListDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
class GameListDataBaseModule {
    @Provides
    fun provideGameListDataBase(
        @ApplicationContext context: Context
    ): GameListDataBase {
        return Room.databaseBuilder(
            context,
            GameListDataBase::class.java,
            GameListDataBase.DATA_BASE_NAME
        ).build()
    }
}