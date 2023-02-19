package com.example.mockktestsapplication.domain

import com.example.mockktestsapplication.data.repositories.DateRepository
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@ExperimentalCoroutinesApi
class GetSuspendDateUseCaseTest {

    private val mockkDateRepository = mockk<DateRepository>{
        coEvery { getSuspendLocalTime() } returns 1000L
    }

    private val systemUnderTest = GetSuspendDateUseCase(mockkDateRepository)

    @Test
    fun `when getSuspendLocalTime is fetched then result and used methods are proper`() = runTest {
        val timeMillis = systemUnderTest()

        coVerify(exactly = 1) { mockkDateRepository.getSuspendLocalTime() }
        timeMillis shouldBe 1000L
    }

}