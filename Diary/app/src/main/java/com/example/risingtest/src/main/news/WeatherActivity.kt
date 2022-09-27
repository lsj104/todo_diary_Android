package com.example.risingtest.src.main.news

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityWeatherBinding
import com.example.risingtest.src.main.news.weathermodels.WeatherResponse

class WeatherActivity : BaseActivity<ActivityWeatherBinding>(ActivityWeatherBinding::inflate), WeatherActivityView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.weatherBtnSearch.setOnClickListener{
            val cityName = binding.weatherEdtLocation.text.toString()
            val API_KEY = "4c7edbfa53e43daef73b9389ed357501"
            showLoadingDialog(this)
            WeatherService(this).tryGetWeather(cityName,API_KEY)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onGetWeatherSuccess(response: WeatherResponse) {
            dismissLoadingDialog()
            binding.weatherTextNow.text = "now: " + ((response.main.temp - 273.15)).toString().substring(0,4) + "℃"
            binding.weatherTextHigh.text = "high temperature: " +((response.main.temp_max -273.15)).toString().substring(0,4) + "℃"
            binding.weatherTextLow.text = "low temperture: " +((response.main.temp_min -273.15)).toString().substring(0,4) + "℃"
    }


    override fun onGetWeatherFailure(message: String) {
        dismissLoadingDialog()
    }

}
