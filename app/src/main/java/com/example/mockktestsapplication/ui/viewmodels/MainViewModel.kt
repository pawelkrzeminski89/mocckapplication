package com.example.mockktestsapplication.ui.viewmodels

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mockktestsapplication.domain.GetDateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getDateUseCase: GetDateUseCase) : ViewModel() {
}