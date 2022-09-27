package com.example.risingtest.src.main.news

import android.content.Context
import com.example.risingtest.src.main.news.weathermodels.WeatherResponse

interface WeatherActivityView {

    fun onGetWeatherSuccess(response: WeatherResponse)
    fun onGetWeatherFailure(message: String)

}