package com.example.gameinformation.domain.repositories.implementations

import com.example.gameinformation.R
import com.example.gameinformation.domain.repositories.RemoteConfigRepository
import com.example.gameinformation.domain.repositories.models.RemoteConfigResult
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import javax.inject.Inject

class RemoteConfigRepositoryImpl @Inject constructor() : RemoteConfigRepository {

    private lateinit var remoteConfig: FirebaseRemoteConfig

    override suspend fun initFirebaseRemoteConfig(result: (RemoteConfigResult) -> Unit) {
        remoteConfig = Firebase.remoteConfig

        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 1
        }

        remoteConfig.apply {
            setConfigSettingsAsync(configSettings)
            setDefaultsAsync(R.xml.remote_config_defaults)
        }

        remoteConfig.fetchAndActivate()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    result(RemoteConfigResult.Success(Unit))
                } else {
                    result(RemoteConfigResult.Error(it.exception))
                }
            }
    }

    override fun isComposeEnable(): Boolean {
        return remoteConfig.getBoolean(IS_COMPOSE_ENABLE_KEY)
    }

    companion object {
        private const val IS_COMPOSE_ENABLE_KEY = "showCompose"
    }
}