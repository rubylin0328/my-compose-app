package com.example.mycomposeapp.data.model.getWeather

import com.squareup.moshi.Json

data class CurrentWeatherData(
    @Json(name = "dt") val dateTime: Long = 0,
    var temp: Double = 0.0,
    @Json(name = "weather") val weatherDescription: List<WeatherDescription> = emptyList()
)