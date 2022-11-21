package com.example.business.domain.usecases.implementations

import com.example.business.domain.repositories.RawgRepository
import com.example.business.domain.usecases.GetRawgApiKeyUseCase
import javax.inject.Inject

class GetRawgApiKeyUseCaseImpl @Inject constructor(
    private val repository: RawgRepository
): GetRawgApiKeyUseCase {

    override fun execute(): String {
        return repository.getRawgApiKey()
    }
}