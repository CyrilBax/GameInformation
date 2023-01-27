package com.example.gameinformation.domain.repositories.models

sealed class RemoteConfigResult {
    data class Success(val unit: Unit) : RemoteConfigResult()
    data class Error(val exception: java.lang.Exception?) : RemoteConfigResult()
}