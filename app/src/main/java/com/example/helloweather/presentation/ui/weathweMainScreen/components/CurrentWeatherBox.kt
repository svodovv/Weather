package com.example.helloweather.presentation.ui.weathweMainScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.helloweather.R
import com.example.helloweather.domain.model.WeatherDataModel

@Composable
fun CurrentWeatherBox(
    weather: WeatherDataModel, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,

        ) {


        Box(
            modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = weather.weatherType.iconRes),
                contentDescription = weather.weatherType.weatherDesc,
                modifier = Modifier.width(144.dp)
            )
        }
        Text(
            text = weather.temperatureCelsius.toString() + "°",
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = weather.weatherType.weatherDesc,
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_drop),
                    contentDescription = "drop",
                    modifier = Modifier.size(30.dp).padding(bottom = 4.dp),

                    )
                Text(
                    text = weather.humidity.toString(),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_pressure),
                    contentDescription = "pressure",
                    modifier = Modifier.size(35.dp)
                )
                Text(
                    text = weather.pressure.toString(),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_wind),
                    contentDescription = "wind",
                    modifier = Modifier.size(35.dp)
                )
                Text(
                    text = weather.windSpeed.toString(),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}