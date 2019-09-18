package com.asama.luong.forecastmvvm.data.network.response


import androidx.annotation.Keep
import com.asama.luong.forecastmvvm.data.db.entity.CurrentWeatherEntry
import com.asama.luong.forecastmvvm.data.db.entity.WeatherLocation
import com.google.gson.annotations.SerializedName

@Keep
data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: WeatherLocation
)