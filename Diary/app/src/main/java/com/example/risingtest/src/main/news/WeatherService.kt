package com.example.risingtest.src.main.news

import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.src.main.news.weathermodels.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherService(val view: WeatherActivity) {

    fun tryGetWeather(q: String, appid:String){
        val WeatherRetrofitInterface = ApplicationClass.sRetrofit.create(WeatherRetrofitInterface::class.java)
        WeatherRetrofitInterface.getWeather(q, appid).enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>){
                view.onGetWeatherSuccess(response.body()as WeatherResponse)
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                view.onGetWeatherFailure(t.message ?: "통신오류")
            }
        })
    }

}

