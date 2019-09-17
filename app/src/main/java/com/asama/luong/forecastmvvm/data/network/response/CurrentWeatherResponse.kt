package com.asama.luong.forecastmvvm.data.network.response


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.asama.luong.forecastmvvm.data.db.entity.CurrentWeatherEntry
import com.asama.luong.forecastmvvm.data.db.entity.Location

@Keep
data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location
)