package com.example.helloweather.data.remote.dto.weatherDto

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.helloweather.domain.model.WeatherDataModel
import com.example.helloweather.domain.model.WeatherInfoModel
import com.example.helloweather.domain.model.WeatherSevenDaysModel
import com.plcoding.weatherapp.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale


private data class IndexedWeatherData(
    val index: Int, val data: WeatherList
)

private data class WeatherList(
    val temperature: Int, val weatherType: Int
)

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDataDto.toWeatherSevenDayModel(): Map<String, WeatherSevenDaysModel> {
    val now = LocalDateTime.now()

    return time.mapIndexed { index, _ ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]

        IndexedWeatherData(
            index = index, data = WeatherList(
                temperature = temperature.toInt(), weatherType = weatherCode
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues { it ->
        val minValue = it.value.minOf { it.data.temperature }
        val maxValue = it.value.maxOf { it.data.temperature }
        val weather = it.value.groupingBy { it.data.weatherType }.eachCount().maxBy { it.value }.key
        WeatherSevenDaysModel(
            minTemperature = minValue,
            maxTemperature = maxValue,
            weatherType = WeatherType.fromWMO(weather)
        )
    }.mapKeys { it ->
        if (it.key == 0) {
            "Сегодня"
        } else {
            now.plusDays(it.key.toLong()).dayOfWeek.getDisplayName(TextStyle.SHORT, Locale("ru"))
                .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDataDto.toCurrentWeatherModel(): List<WeatherDataModel> {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")

    val now = LocalDateTime.now()
    val currentTime = time.map {
        LocalDateTime.parse(it, formatter)
    }
    val currentTimeIndex = currentTime.indexOfFirst { it.hour == now.hour }

    val mutableWeather = mutableListOf<WeatherDataModel>()
    for (index in currentTimeIndex..currentTimeIndex + 24) {
        mutableWeather.add(
            WeatherDataModel(
                time = LocalDateTime.parse(time[index], formatter),
                temperatureCelsius = temperatures[index].toInt(),
                pressure = pressures[index].toInt(),
                windSpeed = windSpeeds[index],
                humidity = humidities[index],
                weatherType = WeatherType.fromWMO(weatherCodes[index])
            )
        )
    }
    return mutableWeather
}

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDto.toWeatherInfo(): WeatherInfoModel {

    return WeatherInfoModel(
        weatherData = weatherData.toWeatherSevenDayModel(),
        currentWeatherData = weatherData.toCurrentWeatherModel(),
    )
}