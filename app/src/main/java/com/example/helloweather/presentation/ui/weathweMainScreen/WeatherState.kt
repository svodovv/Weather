package com.example.helloweather.presentation.ui.weathweMainScreen

import com.example.helloweather.domain.model.WeatherInfoModel

data class WeatherState(
    val weatherList: WeatherInfoModel? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)