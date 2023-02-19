package com.example.mockktestsapplication.domain

import com.example.mockktestsapplication.data.repositories.DateRepository
import javax.inject.Inject

class GetSuspendDateUseCase @Inject constructor(private val dateRepository: DateRepository) {

    suspend operator fun invoke() = dateRepository.getSuspendLocalTime()

}