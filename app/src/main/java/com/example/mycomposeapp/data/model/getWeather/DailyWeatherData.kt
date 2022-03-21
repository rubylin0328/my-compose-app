package com.example.mycomposeapp.data.model.getWeather

import com.squareup.moshi.Json

data class DailyWeatherData(
    @Json(name = "dt") val dateTime: Long = 0,
    var temp: DailyTemp,
    @Json(name = "weather") val weatherDescription: List<WeatherDescription> = emptyList()
)