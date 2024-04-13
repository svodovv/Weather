package com.example.weather.domain.lcoation

import android.location.Location


interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}
