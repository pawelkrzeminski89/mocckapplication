package com.example.mockktestsapplication.data.datasources

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.util.Calendar
import javax.inject.Inject

class DateLocalSource @Inject constructor() {

    fun getLocalTime() = Calendar.getInstance().timeInMillis


    suspend fun getSuspendLocalTime():Long {
        return withContext(Dispatchers.IO) {
            delay(1000L)
            return@withContext Calendar.getInstance().timeInMillis
        }
    }

}