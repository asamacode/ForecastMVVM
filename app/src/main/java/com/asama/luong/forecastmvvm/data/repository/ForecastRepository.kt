package com.asama.luong.forecastmvvm.data.repository

import androidx.lifecycle.LiveData
import com.asama.luong.forecastmvvm.data.db.entity.WeatherLocation
import com.asama.luong.forecastmvvm.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean) : LiveData<out UnitSpecificCurrentWeatherEntry>
    suspend fun getWeatherLocation(): LiveData<WeatherLocation>
}