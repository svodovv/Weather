package com.example.helloweather.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.helloweather.R

val openSans = FontFamily(
    Font(R.font.open_sans_bold, FontWeight.Bold),
    Font(R.font.open_sans_medium, FontWeight.Medium),
    Font(R.font.open_sans_regular, FontWeight.Normal)
)
// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = openSans,
        fontWeight = FontWeight.Medium,
        fontSize = 40.sp,
        color = Color.White
    ),
    displayMedium = TextStyle(
        fontFamily = openSans,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        color = Color.White
    ),
    displaySmall = TextStyle(
        fontFamily = openSans,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = Color.White
    ),
    bodyLarge =  TextStyle(
        fontFamily = openSans,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        color = Color.White
    ),
    bodyMedium = TextStyle(
        fontFamily = openSans,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = Color.White
    ),
    bodySmall = TextStyle(
        fontFamily = openSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color.White
    ),
    headlineMedium = TextStyle(
        fontFamily = openSans,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        color = Color.White
    )
)