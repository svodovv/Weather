package com.example.helloweather.data.remote.retrofit

import com.example.helloweather.data.remote.dto.weatherDto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl")
    suspend fun getWeather(
        @Query("latitude") lat: Double,
        @Query("longitude") lon: Double,
    ): WeatherDto
}