package com.example.mycomposeapp.data.model.getWeather

data class GetWeatherResponse(
    val current: CurrentWeatherData,
    val daily: List<DailyWeatherData>
)
