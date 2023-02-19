package com.example.mockktestsapplication.data.datasources


import io.kotest.inspectors.runTests
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.unmockkStatic
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.Calendar
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

@ExperimentalCoroutinesApi
class DateLocalSourceTest {

    private val mockkCalendar = mockk<Calendar>() {
        every { timeInMillis } returns 1000L
    }
    private val testDispatcher = UnconfinedTestDispatcher()

    private val systemUnderTest = DateLocalSource()

    @Before
    fun before() {
        mockkStatic(Calendar::class)
        every { Calendar.getInstance() } returns mockkCalendar
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun teardown() {
        unmockkStatic(Calendar::class)
        Dispatchers.resetMain()
    }

    @Test
    fun `when getLocalTime is fetched then result is proper`() {
        val timeMillis = systemUnderTest.getLocalTime()

        verify { mockkCalendar.timeInMillis }
        timeMillis shouldBe 1000L
    }

    @Test
    fun `when getSuspendLocalTime is fetched then result is proper`() = runTest {
        val timeMillis = systemUnderTest.getSuspendLocalTime()

        verify { mockkCalendar.timeInMillis }
        timeMillis shouldBe 1000L
    }
}