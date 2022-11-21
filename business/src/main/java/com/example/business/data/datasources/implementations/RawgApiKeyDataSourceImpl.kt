package com.example.business.data.datasources.implementations

import com.example.business.data.datasources.RawgApiKeyDataSource
import javax.inject.Inject

class RawgApiKeyDataSourceImpl @Inject constructor(): RawgApiKeyDataSource {

    override fun getRawgApiKey(): String {
        val key = getApiKey()
        return key
    }

    private external fun getApiKey(): String
}