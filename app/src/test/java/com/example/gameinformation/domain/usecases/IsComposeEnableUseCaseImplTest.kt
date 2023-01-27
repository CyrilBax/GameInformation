package com.example.gameinformation.domain.usecases

import com.example.gameinformation.domain.repositories.RemoteConfigRepository
import com.example.gameinformation.domain.usecases.implementations.IsComposeEnableUseCaseImpl
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test

class IsComposeEnableUseCaseImplTest {

    private lateinit var useCase: IsComposeEnableUseCaseImpl
    private val repository: RemoteConfigRepository = mock()

    @Before
    fun setup() {
        useCase = IsComposeEnableUseCaseImpl(repository)
    }

    @Test
    fun `should return true`() {
        whenever(repository.isComposeEnable()).thenReturn(true)
        val result = useCase.execute()
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `should return false`() {
        whenever(repository.isComposeEnable()).thenReturn(false)
        val result = useCase.execute()
        assertThat(result).isEqualTo(false)
    }
}