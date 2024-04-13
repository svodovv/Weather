package com.example.helloweather.presentation.ui.weathweMainScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.helloweather.domain.model.WeatherSevenDaysModel

@Composable
fun WeatherFor7Days(
    weatherMap: Map<String, WeatherSevenDaysModel>,
    color: Color,
    modifier: Modifier = Modifier,

    ) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = color),
        shape = RoundedCornerShape(20.dp)
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = "Погода на 7 дней",
                style = MaterialTheme.typography.headlineMedium)
            weatherMap.keys.forEach {
                Column(modifier = Modifier.padding(bottom = 8.dp)) {
                    Divider(
                        modifier = Modifier.fillMaxWidth(), thickness = 1.dp, Color.Gray
                    )
                    Row(modifier = Modifier.padding(top = 4.dp)) {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.weight(1f)
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(3f)
                        ) {
                            Image(
                                painter = painterResource(id = weatherMap[it]?.weatherType!!.iconRes),
                                contentDescription = weatherMap[it]?.weatherType!!.weatherDesc,
                                modifier = Modifier
                                    .weight(1f),
                            )
                            Text(
                                text = weatherMap[it]?.minTemperature.toString()+ "°",
                                modifier = Modifier.weight(1f).padding(end = 8.dp),
                                textAlign = TextAlign.End,
                                style = MaterialTheme.typography.bodyLarge,
                            )
                            Box(
                                modifier = Modifier
                                    .weight(2f)
                                    .height(3.dp)
                                    .clip(RoundedCornerShape(10))
                                    .background(Color.Transparent)
                                    .drawWithContent {
                                        val width = size.width
                                        val height = size.height

                                        val gradient = Brush.linearGradient(
                                            colors = listOf(Color(0xFF0028FF), Color(0xFFFF5722)),
                                            start = Offset(0f, 0f),
                                            end = Offset(width, height)
                                        )

                                        drawIntoCanvas {
                                            drawRect(
                                                topLeft = Offset.Zero,
                                                size = Size(width, height),
                                                brush = gradient,
                                                blendMode = androidx.compose.ui.graphics.BlendMode.SrcIn
                                            )
                                        }
                                    }
                                    .align(Alignment.CenterVertically)
                            )
                            Text(
                                text = weatherMap[it]?.maxTemperature.toString()+ "°",
                                modifier = Modifier
                                    .padding(end = 8.dp)
                                    .weight(1f)
                                    .fillMaxWidth(),
                                textAlign = TextAlign.End,
                                style = MaterialTheme.typography.bodyLarge,
                            )
                        }
                    }
                }
            }
        }

    }
}

