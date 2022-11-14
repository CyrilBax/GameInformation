package com.example.game_list_data.datasources.remote.implementations

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.core.content.ContextCompat
import com.example.commons.Mapper
import com.example.game_list_data.datasources.models.GameListModel
import com.example.game_list_data.datasources.remote.GameListRemoteDataSource
import com.example.game_list_data.sources.GameListSource
import com.example.game_list_data.sources.models.GameListRemoteModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GameListRemoteDataSourceImpl @Inject constructor(
    private val service: GameListSource,
    private val mapper: Mapper<GameListRemoteModel, GameListModel>,
    @ApplicationContext private val context: Context
) : GameListRemoteDataSource {

    override suspend fun getGameList(page: Int): GameListModel {
        return mapper.mapTo(service.getGameList(page))
    }

    override suspend fun isOnline(): Boolean {
        val connMgr =
            ContextCompat.getSystemService(context, ConnectivityManager::class.java) as ConnectivityManager
        val networkInfo: NetworkInfo? = connMgr.activeNetworkInfo
        return networkInfo?.isConnected == true
    }
}