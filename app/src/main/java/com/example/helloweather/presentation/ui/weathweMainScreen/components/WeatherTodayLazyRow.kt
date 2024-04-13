package com.example.helloweather.presentation.ui.weathweMainScreen.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.helloweather.domain.model.WeatherDataModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherTodayLazyRow(
    weatherList: List<WeatherDataModel>,
    modifier: Modifier = Modifier,
    cardColor: Color
) {

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = cardColor),
        shape = RoundedCornerShape(16.dp)
    ) {

        Column(modifier = Modifier
            .padding(8.dp)) {
            Text(
                text = "Погода на сегодня",
                style = MaterialTheme.typography.headlineMedium
            )
            Divider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp, Color.Gray
            )
        }
        LazyRow(modifier = Modifier.background(cardColor)) {
            itemsIndexed(items = weatherList) { index, it ->
                Column(
                    modifier = Modifier.padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = if (index == 0) {
                            "Сейчас"
                        } else it.time.hour.toString(),
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.displaySmall
                    )
                    Box(modifier = Modifier) {
                        Image(
                            painter = painterResource(id = it.weatherType.iconRes),
                            contentDescription = it.weatherType.weatherDesc,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Text(text = "${it.temperatureCelsius}" + "°")
                }
            }
        }
    }
}
