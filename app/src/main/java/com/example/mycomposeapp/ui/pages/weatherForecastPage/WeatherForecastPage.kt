package com.example.mycomposeapp.ui.pages.weatherForecastPage

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.mycomposeapp.R
import com.example.mycomposeapp.data.model.getWeather.DailyWeatherData
import kotlin.math.roundToInt

val weatherForecastPageViewModel = WeatherForecastPageViewModel()

@Composable
fun WeatherForecastPage() {
    if (weatherForecastPageViewModel.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                color = MaterialTheme.colors.secondary,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    } else {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            item {
                CurrentWeather()
            }

            items(weatherForecastPageViewModel.weeklyWeather) { item ->
                DailyWeather(item)
            }
        }
    }
}

@Composable
fun CurrentWeather() {
    Column {
        // current time
        Text(
            text = weatherForecastPageViewModel.timeStampToDate(
                timeStamp = weatherForecastPageViewModel.currentWeather.dateTime,
                dateFormat = "MMM dd, EEE, HH:mm:ss"
            ),
            modifier = Modifier.padding(
                top = 20.dp,
                start = 20.dp
            )
        )

        // current weather
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Row {
                Text(
                    text = weatherForecastPageViewModel.currentWeather.temp.roundToInt()
                        .toString(),
                    fontSize = 150.sp,
                    modifier = Modifier.alignByBaseline()
                )

                Text(
                    text = stringResource(id = R.string.celsius),
                    fontSize = 50.sp,
                    modifier = Modifier.alignByBaseline()
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = rememberImagePainter("https://openweathermap.org/img/wn/${weatherForecastPageViewModel.currentWeather.weatherDescription[0].icon}@2x.png"),
                    contentDescription = "weather icon",
                    modifier = Modifier
                        .size(100.dp)
                )

                Text(text = weatherForecastPageViewModel.currentWeather.weatherDescription[0].description)
            }
        }
    }
}

@Composable
fun DailyWeather(dailyWeather: DailyWeatherData) {
    Divider()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 30.dp, start = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = weatherForecastPageViewModel.timeStampToDate(
                timeStamp = dailyWeather.dateTime,
                dateFormat = "MMM dd, EEE"
            )
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = rememberImagePainter("https://openweathermap.org/img/wn/${dailyWeather.weatherDescription[0].icon}@2x.png"),
                    contentDescription = "weather icon",
                    modifier = Modifier.size(80.dp)
                )

                Text(
                    text = dailyWeather.weatherDescription[0].description,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
            }

            Spacer(modifier = Modifier.width(30.dp))

            Column(horizontalAlignment = Alignment.End) {
                Text(text = dailyWeather.temp.max.roundToInt().toString())

                Spacer(modifier = Modifier.height(10.dp))

                Text(text = dailyWeather.temp.min.roundToInt().toString())
            }
        }
    }
}

