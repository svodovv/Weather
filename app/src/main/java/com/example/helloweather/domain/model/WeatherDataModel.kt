package com.example.helloweather.domain.model

import com.plcoding.weatherapp.domain.weather.WeatherType
import java.time.LocalDateTime

data class WeatherDataModel(
    val time: LocalDateTime,
    val temperatureCelsius: Int,
    val pressure: Int,
    val windSpeed: Double,
    val humidity: Double,
    val weatherType: WeatherType
)
