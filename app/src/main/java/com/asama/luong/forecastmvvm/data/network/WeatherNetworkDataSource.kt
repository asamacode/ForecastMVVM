package com.asama.luong.forecastmvvm.data.network

import androidx.lifecycle.LiveData
import com.asama.luong.forecastmvvm.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )
}