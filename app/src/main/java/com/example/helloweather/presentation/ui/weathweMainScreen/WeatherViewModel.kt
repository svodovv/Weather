package com.example.helloweather.presentation.ui.weathweMainScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helloweather.common.Resource
import com.example.helloweather.domain.use_case.getWeatherUseCase.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import java.time.LocalDateTime
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherUseCase: WeatherUseCase,
) : ViewModel() {

    private val _weatherState = MutableStateFlow(WeatherState())
    val weatherState = _weatherState.asStateFlow()

    init {
        loadWeatherInfo()

    }


    private fun loadWeatherInfo() {
        weatherUseCase.loadWeather().onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    _weatherState.update {
                        it.copy(
                            weatherList = resource.data,
                            isLoading = false
                        )
                    }
                }

                is Resource.Loading -> {
                    _weatherState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                }

                is Resource.Error -> {
                    _weatherState.update {
                        it.copy(
                            errorMessage = resource.message,
                            isLoading = false
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }


}