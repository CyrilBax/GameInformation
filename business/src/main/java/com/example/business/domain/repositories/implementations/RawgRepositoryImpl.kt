package com.example.business.domain.repositories.implementations

import com.example.business.data.datasources.RawgApiKeyDataSource
import com.example.business.domain.repositories.RawgRepository
import javax.inject.Inject

class RawgRepositoryImpl @Inject constructor(
    private val dataSource: RawgApiKeyDataSource
): RawgRepository {

    override fun getRawgApiKey(): String {
        return dataSource.getRawgApiKey()
    }
}