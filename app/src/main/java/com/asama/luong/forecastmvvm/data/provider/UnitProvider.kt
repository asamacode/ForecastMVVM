package com.asama.luong.forecastmvvm.data.provider

import com.asama.luong.forecastmvvm.internal.UnitSystem

interface UnitProvider {
    fun getUnitSystem(): UnitSystem
}