package com.example.helloweather.domain.model

data class WeatherInfoModel(
    val weatherData: Map<String, WeatherSevenDaysModel>,
    val currentWeatherData: List<WeatherDataModel>,
)
