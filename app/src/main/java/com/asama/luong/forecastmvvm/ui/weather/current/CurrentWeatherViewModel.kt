package com.asama.luong.forecastmvvm.ui.weather.current

import androidx.lifecycle.ViewModel;
import com.asama.luong.forecastmvvm.data.repository.ForecastRepository
import com.asama.luong.forecastmvvm.internal.UnitSystem
import com.asama.luong.forecastmvvm.internal.lazyDefered

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {

    private val unitSystem = UnitSystem.METRIC

    val isMetric: Boolean
    get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDefered {
        forecastRepository.getCurrentWeather(isMetric)
    }
}
