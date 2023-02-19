package com.example.mockktestsapplication.data.repositories

import com.example.mockktestsapplication.data.datasources.DateLocalSource
import javax.inject.Inject

class DateRepository @Inject constructor(private val dateLocalSource: DateLocalSource) {

    fun getLocalTime() = dateLocalSource.getLocalTime()

    suspend fun getSuspendLocalTime() = dateLocalSource.getSuspendLocalTime()

}