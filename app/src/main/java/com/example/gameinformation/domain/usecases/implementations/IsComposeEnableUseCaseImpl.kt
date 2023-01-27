package com.example.gameinformation.domain.usecases.implementations

import com.example.gameinformation.domain.repositories.RemoteConfigRepository
import com.example.gameinformation.domain.usecases.IsComposeEnableUseCase
import javax.inject.Inject

class IsComposeEnableUseCaseImpl @Inject constructor(
    private val repository: RemoteConfigRepository
) : IsComposeEnableUseCase {

    override fun execute(): Boolean {
        return repository.isComposeEnable()
    }
}