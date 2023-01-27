package com.example.gameinformation.domain.usecases

import com.example.gameinformation.domain.repositories.models.RemoteConfigResult

interface InitFirebaseRemoteConfigUseCase {
    suspend fun execute(result: (RemoteConfigResult) -> Unit)
}