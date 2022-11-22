package com.example.game_page_data.cache.profiles

import android.content.Context
import androidx.room.Room
import com.example.game_page_data.cache.GamePageDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
class GamePageDataBaseModule {
    @Provides
    fun provideGamePageDataBase(
        @ApplicationContext context: Context
    ): GamePageDataBase {
        return Room.databaseBuilder(
            context,
            GamePageDataBase::class.java,
            GamePageDataBase.DATA_BASE_NAME
        ).build()
    }
}