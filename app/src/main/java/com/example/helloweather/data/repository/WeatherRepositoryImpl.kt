package com.example.helloweather.data.repository

import com.example.helloweather.data.remote.dto.weatherDto.WeatherDto
import com.example.helloweather.data.remote.retrofit.WeatherApi
import com.example.helloweather.domain.repository.WeatherRepository
import javax.inject.Inject


class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi
) : WeatherRepository {


    override suspend fun getWeatherFiveDay(): WeatherDto {
        return weatherApi.getWeather(
            lat = 54.58,
            lon = 73.23,
        )
    }
}
