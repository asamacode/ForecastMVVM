package com.asama.luong.forecastmvvm.data.repository

import androidx.lifecycle.LiveData
import com.asama.luong.forecastmvvm.data.db.entity.WeatherLocation
import com.asama.luong.forecastmvvm.data.db.unitlocalized.current.UnitSpecificCurrentWeatherEntry
import com.asama.luong.forecastmvvm.data.db.unitlocalized.future.UnitSpecificSimpleFutureWeatherEntry
import org.threeten.bp.LocalDate

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean) : LiveData<out UnitSpecificCurrentWeatherEntry>

    suspend fun getFutureWeatherList(startDate: LocalDate, metric: Boolean): LiveData<out List<UnitSpecificSimpleFutureWeatherEntry>>

    suspend fun getWeatherLocation(): LiveData<WeatherLocation>
}