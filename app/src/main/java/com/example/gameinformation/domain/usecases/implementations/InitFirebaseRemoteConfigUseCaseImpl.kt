package com.example.gameinformation.domain.usecases.implementations

import com.example.gameinformation.domain.repositories.RemoteConfigRepository
import com.example.gameinformation.domain.repositories.models.RemoteConfigResult
import com.example.gameinformation.domain.usecases.InitFirebaseRemoteConfigUseCase
import javax.inject.Inject


class InitFirebaseRemoteConfigUseCaseImpl @Inject constructor(
    private val repository: RemoteConfigRepository
) : InitFirebaseRemoteConfigUseCase {

    override suspend fun execute(result: (RemoteConfigResult) -> Unit) {
        repository.initFirebaseRemoteConfig(result)
    }
}