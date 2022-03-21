package com.example.mycomposeapp.data.network

import com.example.mycomposeapp.data.model.getWeather.GetWeatherResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiWeather {
    @GET("onecall")
    suspend fun getWeather(
        @Query("lat") lat: String = "25.04",
        @Query("lon") lon: String = "121.56",
        @Query("appid") appid: String = "e57b86472322647b1fae36200ca3f00f",
        @Query("exclude") exclude: String = "minutely,hourly,alerts",
        @Query("units") units: String = "metric",
        @Query("lang") lang: String = "zh_tw"
    ): GetWeatherResponse
}

object Api {
    val weather: ApiWeather by lazy {
        retrofit.create(ApiWeather::class.java)
    }
}