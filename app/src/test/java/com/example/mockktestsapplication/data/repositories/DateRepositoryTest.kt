package com.example.mockktestsapplication.data.repositories

import com.example.mockktestsapplication.data.datasources.DateLocalSource
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
class DateRepositoryTest {

    private val mockkDateLocalSource = mockk<DateLocalSource>{
        every { getLocalTime() } returns 1000L
        coEvery { getSuspendLocalTime() } returns 1000L
    }

    private val systemUnderTest = DateRepository(mockkDateLocalSource)

    @Test
    fun `when getLocalTime() is fetched then result is proper`() {
        val timeMillis = systemUnderTest.getLocalTime()

        verify(exactly = 1) { mockkDateLocalSource.getLocalTime() }
        timeMillis shouldBe 1000L
    }

    @Test
    fun `when getSuspendLocalTime() is fetched then result is proper`() = runTest {
        val timeMillis = systemUnderTest.getSuspendLocalTime()

        coVerify(exactly = 1) { mockkDateLocalSource.getSuspendLocalTime() }
        timeMillis shouldBe 1000L
    }

}