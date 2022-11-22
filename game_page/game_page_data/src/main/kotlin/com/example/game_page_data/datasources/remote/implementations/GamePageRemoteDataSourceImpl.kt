package com.example.game_page_data.datasources.remote.implementations

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.core.content.ContextCompat
import com.example.commons.Mapper
import com.example.game_page_data.datasources.models.GamePageModel
import com.example.game_page_data.datasources.remote.GamePageRemoteDataSource
import com.example.game_page_data.services.GamePageService
import com.example.game_page_data.services.models.GamePageModelRemote
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GamePageRemoteDataSourceImpl @Inject constructor(
    private val service: GamePageService,
    private val mapper: Mapper<GamePageModelRemote, GamePageModel>,
    @ApplicationContext private val context: Context
) : GamePageRemoteDataSource {

    override suspend fun getGamePage(gameId: String): GamePageModel {
        return mapper.mapTo(service.getGamePage(gameId))
    }

    override suspend fun isOnline(): Boolean {
        val connMgr =
            ContextCompat.getSystemService(
                context,
                ConnectivityManager::class.java
            ) as ConnectivityManager
        val networkInfo: NetworkInfo? = connMgr.activeNetworkInfo
        return networkInfo?.isConnected == true
    }
}