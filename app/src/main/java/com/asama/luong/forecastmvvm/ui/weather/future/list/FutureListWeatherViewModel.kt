package com.asama.luong.forecastmvvm.ui.weather.future.list

import com.asama.luong.forecastmvvm.data.provider.UnitProvider
import com.asama.luong.forecastmvvm.data.repository.ForecastRepository
import com.asama.luong.forecastmvvm.internal.lazyDefered
import com.asama.luong.forecastmvvm.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureListWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weatherEntries by lazyDefered {
        forecastRepository.getFutureWeatherList(LocalDate.now(), super.isMetric)
    }
}
