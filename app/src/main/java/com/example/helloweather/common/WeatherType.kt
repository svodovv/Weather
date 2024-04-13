package com.plcoding.weatherapp.domain.weather

import androidx.annotation.DrawableRes
import com.example.helloweather.R

sealed class WeatherType(
    val weatherDesc: String,
    @DrawableRes val iconRes: Int
) {
    data object ClearSky : WeatherType(
        weatherDesc = "Чистое небо",
        iconRes = R.drawable.ic_sunny
    )
    data object MainlyClear : WeatherType(
        weatherDesc = "преимущественно ясно",
        iconRes = R.drawable.ic_cloudy
    )
    data object PartlyCloudy : WeatherType(
        weatherDesc = "Переменная облачность",
        iconRes = R.drawable.ic_cloudy
    )
    data object Overcast : WeatherType(
        weatherDesc = "Облачно",
        iconRes = R.drawable.ic_cloudy
    )
    data object Foggy : WeatherType(
        weatherDesc = "Туманно",
        iconRes = R.drawable.ic_very_cloudy
    )
    data object DepositingRimeFog : WeatherType(
        weatherDesc = "Иней",
        iconRes = R.drawable.ic_very_cloudy
    )
    data object LightDrizzle : WeatherType(
        weatherDesc = "Грибной дождь",
        iconRes = R.drawable.ic_rainshower
    )
    data object ModerateDrizzle : WeatherType(
        weatherDesc = "Дождик",
        iconRes = R.drawable.ic_rainshower
    )
    data object DenseDrizzle : WeatherType(
        weatherDesc = "Дождик",
        iconRes = R.drawable.ic_rainshower
    )
    data object LightFreezingDrizzle : WeatherType(
        weatherDesc = "Slight freezing drizzle",
        iconRes = R.drawable.ic_snowyrainy
    )
    data object DenseFreezingDrizzle : WeatherType(
        weatherDesc = "Небольшие заморозки",
        iconRes = R.drawable.ic_snowyrainy
    )
    data object SlightRain : WeatherType(
        weatherDesc = "Небольшой дождь",
        iconRes = R.drawable.ic_rainy
    )
    data object ModerateRain : WeatherType(
        weatherDesc = "Дождь",
        iconRes = R.drawable.ic_rainy
    )
    data object HeavyRain : WeatherType(
        weatherDesc = "Сильный дождь",
        iconRes = R.drawable.ic_rainy
    )
    data object HeavyFreezingRain: WeatherType(
        weatherDesc = "Холодный дождь",
        iconRes = R.drawable.ic_snowyrainy
    )
    data object SlightSnowFall: WeatherType(
        weatherDesc = "Небольшой снег",
        iconRes = R.drawable.ic_snowy
    )
    data object ModerateSnowFall: WeatherType(
        weatherDesc = "Moderate snow fall",
        iconRes = R.drawable.ic_heavysnow
    )
    data object HeavySnowFall: WeatherType(
        weatherDesc = "Умеренный снег",
        iconRes = R.drawable.ic_heavysnow
    )
    data object SnowGrains: WeatherType(
        weatherDesc = "Snow grains",
        iconRes = R.drawable.ic_heavysnow
    )
    data object SlightRainShowers: WeatherType(
        weatherDesc = "Снег",
        iconRes = R.drawable.ic_rainshower
    )
    data object ModerateRainShowers: WeatherType(
        weatherDesc = "Ливень",
        iconRes = R.drawable.ic_rainshower
    )
    data object ViolentRainShowers: WeatherType(
        weatherDesc = "Сильный ливень",
        iconRes = R.drawable.ic_rainshower
    )
    data object SlightSnowShowers: WeatherType(
        weatherDesc = "Небольшой снег с дождём",
        iconRes = R.drawable.ic_snowy
    )
    data object HeavySnowShowers: WeatherType(
        weatherDesc = "Снег с дождём",
        iconRes = R.drawable.ic_snowy
    )
    data object ModerateThunderstorm: WeatherType(
        weatherDesc = "Гроза",
        iconRes = R.drawable.ic_thunder
    )
    data object SlightHailThunderstorm: WeatherType(
        weatherDesc = "Гроза с градом",
        iconRes = R.drawable.ic_rainythunder
    )
    data object HeavyHailThunderstorm: WeatherType(
        weatherDesc = "Гроза с сильным градом",
        iconRes = R.drawable.ic_rainythunder
    )

    companion object {
        fun fromWMO(code: Int): WeatherType {
            return when(code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> ClearSky
            }
        }
    }
}