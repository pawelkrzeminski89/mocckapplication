package com.example.mockktestsapplication.domain

import com.example.mockktestsapplication.data.repositories.DateRepository
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test

@ExperimentalCoroutinesApi
class GetDateUseCaseTest {

    private val mockkDateRepository = mockk<DateRepository>{
        every { getLocalTime() } returns 1000L
    }

    private val systemUnderTest = GetDateUseCase(mockkDateRepository)

    @Test
    fun `when GetDateUseCase is fetched then result and used methods are proper`() {
        val timeMillis = systemUnderTest()

        verify(exactly = 1) { mockkDateRepository.getLocalTime() }
        timeMillis shouldBe 1000L
    }

}