package com.asama.luong.forecastmvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.asama.luong.forecastmvvm.data.db.entity.CurrentWeatherEntry
import com.asama.luong.forecastmvvm.data.db.entity.WeatherLocation

@Database(
    entities = [CurrentWeatherEntry::class, WeatherLocation::class],
    version = 1)

abstract class ForecastDatabase: RoomDatabase() {
    abstract fun currentWeatherDao(): CurrentWeatherDao
    abstract fun weatherLocationDao(): WeatherLocationDao

    companion object {
        @Volatile private var instance: ForecastDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buidDatabase(context).also { instance = it}
        }

        private fun buidDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ForecastDatabase::class.java,
                "forecast.db").build()
    }
}