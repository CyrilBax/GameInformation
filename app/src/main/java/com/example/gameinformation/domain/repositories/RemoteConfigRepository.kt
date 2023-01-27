package com.example.gameinformation.domain.repositories

import com.example.gameinformation.domain.repositories.models.RemoteConfigResult

interface RemoteConfigRepository {
    suspend fun initFirebaseRemoteConfig(result: (RemoteConfigResult) -> Unit)
    fun isComposeEnable(): Boolean
}