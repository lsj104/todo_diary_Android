package com.example.risingtest.src.main.news

import com.example.risingtest.src.main.news.weathermodels.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherRetrofitInterface {
    @GET("weather")
    fun getWeather(@Query("q") q:String,
                   @Query("appid") appid:String
    ) : Call<WeatherResponse>
}