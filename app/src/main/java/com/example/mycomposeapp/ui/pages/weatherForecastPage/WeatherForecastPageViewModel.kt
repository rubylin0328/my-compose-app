package com.example.mycomposeapp.ui.pages.weatherForecastPage

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycomposeapp.data.model.getWeather.CurrentWeatherData
import com.example.mycomposeapp.data.model.getWeather.DailyWeatherData
import com.example.mycomposeapp.data.network.Api
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class WeatherForecastPageViewModel : ViewModel() {
    var currentWeather by mutableStateOf(CurrentWeatherData())
        private set

    var weeklyWeather = mutableStateListOf<DailyWeatherData>()
        private set

    var isLoading by mutableStateOf(false)
        private set

    init {
        getWeather()
    }

    private fun getWeather() {
        viewModelScope.launch {
            try {
                isLoading = true

                val response = Api.weather.getWeather()

                currentWeather = response.current
                weeklyWeather.reload(response.daily)
            } catch (e: Exception) {
                Log.d("bruce", e.message.toString())
            } finally {
                isLoading = false
            }
        }
    }

    fun timeStampToDate(timeStamp: Long, dateFormat: String): String {
        val simpleDateFormat = SimpleDateFormat(dateFormat)

        val date = Date(timeStamp * 1000)

        return simpleDateFormat.format(date)
    }

    private fun <T> SnapshotStateList<T>.reload(newList: List<T>) {
        clear()
        addAll(newList)
    }
}