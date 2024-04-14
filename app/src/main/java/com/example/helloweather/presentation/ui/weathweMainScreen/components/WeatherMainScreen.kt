package com.example.helloweather.presentation.ui.weathweMainScreen.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.helloweather.presentation.ui.weathweMainScreen.WeatherViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherMainScreen(
    weatherViewModel: WeatherViewModel = hiltViewModel()
) {
    val weatherState = weatherViewModel.weatherState.collectAsStateWithLifecycle().value

    val colors =/* listOf(
        Color(0xFFFF5722),
        Color(0xFF41ABFF),
        Color(0xFF82C8FF),
        Color(0xFFFFFFFF),
    )*/
        listOf(
            Color(0xFF0D1853),
            Color(0xFF232B55),
            Color(0xFF383E64),
        )



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors
                )
            )
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (weatherState.weatherList != null) {
            Spacer(modifier = Modifier.size(100.dp))

            CurrentWeatherBox(
                weather = weatherState.weatherList.currentWeatherData[0],
                modifier = Modifier.fillMaxWidth()
            )

            WeatherTodayLazyRow(
                weatherList = weatherState.weatherList.currentWeatherData,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                cardColor = colors[1]
            )

            WeatherFor7Days(
                weatherState.weatherList.weatherData,
                modifier = Modifier
                    .background(Color.Transparent)
                    .padding(12.dp),
                color = colors[1]
            )

        } else if (weatherState.errorMessage != null) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = weatherState.errorMessage.toString(),
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.CenterHorizontally),
                    color = Color.Red,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center

                )
            }
        } else {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                )
            }
        }
    }
}