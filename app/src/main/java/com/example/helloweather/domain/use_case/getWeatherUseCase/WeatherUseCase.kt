package com.example.helloweather.domain.use_case.getWeatherUseCase

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.helloweather.common.Resource
import com.example.helloweather.data.remote.dto.weatherDto.toWeatherInfo
import com.example.helloweather.data.repository.WeatherRepositoryImpl
import com.example.helloweather.domain.model.WeatherInfoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepositoryImpl
) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun loadWeather(): Flow<Resource<WeatherInfoModel>> = flow {
        try {
            emit(Resource.Loading())
            val weatherInfo = weatherRepository.getWeatherFiveDay().toWeatherInfo()
            emit(Resource.Success(weatherInfo))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Error HttpException in WeatherUseCase"))
            Log.e("WeatherUseCase", "HttpException")
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Error IOException in WeatherUseCase"))
            Log.e("WeatherUseCase", "IOException")
        }
    }
}