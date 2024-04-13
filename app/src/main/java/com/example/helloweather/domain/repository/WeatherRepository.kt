package com.example.helloweather.domain.repository

import com.example.helloweather.data.remote.dto.weatherDto.WeatherDto

interface WeatherRepository {
    suspend fun getWeatherFiveDay(): WeatherDto?
}