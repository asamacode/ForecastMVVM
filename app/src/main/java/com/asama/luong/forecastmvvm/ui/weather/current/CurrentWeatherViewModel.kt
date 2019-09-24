package com.asama.luong.forecastmvvm.ui.weather.current

import com.asama.luong.forecastmvvm.data.provider.UnitProvider
import com.asama.luong.forecastmvvm.data.repository.ForecastRepository
import com.asama.luong.forecastmvvm.internal.lazyDefered
import com.asama.luong.forecastmvvm.ui.base.WeatherViewModel

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDefered {
        forecastRepository.getCurrentWeather(super.isMetric)
    }
}
