package com.example.mycomposeapp.ui.appNavHost

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycomposeapp.ui.pages.weatherForecastPage.WeatherForecastPage

object Destinations {
    const val WEATHER_FORECAST_PAGE = "weather forecast"
}

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = Destinations.WEATHER_FORECAST_PAGE
    ) {
        composable(Destinations.WEATHER_FORECAST_PAGE) {
            WeatherForecastPage()
        }
    }
}