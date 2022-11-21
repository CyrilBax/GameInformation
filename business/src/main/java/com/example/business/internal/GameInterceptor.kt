package com.example.business.internal

import okhttp3.Interceptor
import okhttp3.Response

class GameInterceptor(
    private val key: String
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val requestBuilder = original.newBuilder()

        // Add keys
        val finalUrl = original.url.newBuilder().addQueryParameter("key", key).build()

        val newRequest = requestBuilder
            .header("Content-Type", "application/json")
            .url(finalUrl).build()
        return chain.proceed(newRequest)
    }
}