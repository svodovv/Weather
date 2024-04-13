package com.example.helloweather.domain.model

import com.plcoding.weatherapp.domain.weather.WeatherType
import java.time.LocalDateTime

data class WeatherSevenDaysModel (
    val minTemperature: Int,
    val maxTemperature: Int,
    val weatherType: WeatherType
)