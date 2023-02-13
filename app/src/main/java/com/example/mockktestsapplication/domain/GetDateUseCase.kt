package com.example.mockktestsapplication.domain

import com.example.mockktestsapplication.data.repositories.DateRepository
import javax.inject.Inject

class GetDateUseCase @Inject constructor(private val dateRepository: DateRepository) {

    operator fun invoke() = dateRepository.getLocalTime()

}