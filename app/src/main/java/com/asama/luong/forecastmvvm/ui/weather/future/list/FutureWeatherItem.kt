package com.asama.luong.forecastmvvm.ui.weather.future.list

import com.asama.luong.forecastmvvm.R
import com.asama.luong.forecastmvvm.data.db.unitlocalized.future.MetricSimpleFutureWeatherEntry
import com.asama.luong.forecastmvvm.data.db.unitlocalized.future.UnitSpecificSimpleFutureWeatherEntry
import com.asama.luong.forecastmvvm.internal.glide.GlideApp
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_future_weather.*
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle

class FutureWeatherItem(
    val weatherEntry: UnitSpecificSimpleFutureWeatherEntry
) : Item(){
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.apply {
            textView_condition.text = weatherEntry.conditionText
            updateDate()
            updateTemperature()
            updateConditionImage()
        }
    }

    override fun getLayout() = R.layout.item_future_weather

    private fun ViewHolder.updateDate() {
        val dtFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
        textView_date.text = weatherEntry.date.format(dtFormatter)
    }

    private fun ViewHolder.updateTemperature() {
        val unitAbbreviation = if (weatherEntry is MetricSimpleFutureWeatherEntry) "°C"
        else "°F"
        textView_temperature.text = "${weatherEntry.avgTemperature} $unitAbbreviation"
    }

    private fun ViewHolder.updateConditionImage() {
        GlideApp.with(this.containerView)
            .load("http:"+ weatherEntry.conditionIconUrl)
            .into(imageView_condition_icon)
    }
}