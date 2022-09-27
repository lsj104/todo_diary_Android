package com.example.risingtest.config

import android.app.Application
import android.content.SharedPreferences
import com.kakao.sdk.common.KakaoSdk
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


//각종 전역변수와 앱이 실행될 동안 한번만 유지되면 되는 객체들을 생성하는 코드
class ApplicationClass : Application(){


    val API_URL = "https://api.openweathermap.org/data/2.5/"

    // Movie 서버 주소
    val API_MOVIE_URL = "https://api.themoviedb.org/3/"

    // 실 서버 주소
    // val API_URL = "http://api.test.com/"

    //코틀린 전역변수 문법
    companion object{
        lateinit var sSharedPreferences: SharedPreferences

        //jwt token header 키값
        val X_ACCESS_TOKEN = "X-ACCESS-TOKEN"

        // Retrofit 인스턴스, 앱 실행시 한번만 생성하여 사용
        lateinit var sRetrofit: Retrofit
        lateinit var mRetrofit: Retrofit
    }

    override fun onCreate() {
        super.onCreate()
        sSharedPreferences = applicationContext.getSharedPreferences("todo", MODE_PRIVATE)

        //레트로핏 인스턴스 생성
        initRetrofitInstance()


        KakaoSdk.init(this, "2439727cce7af9c5769f07bd1bcd31c5")
    }

    // 레트로핏 인스턴스를 생성하고, 레트로핏에 각종 설정값들을 지정
    // 연결 타임아웃시간은 5초로 지정이 되어있고, HttpLoggingInterceptor를 붙여서 어떤 요청이 나가고 들어오는지를 보여줌
    private fun initRetrofitInstance() {
        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
        // 로그캣에 okhttp.OkHttpClient로 검색하면 http 통신 내용을 보여줌
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addNetworkInterceptor(XAccessTokenInterceptor())
            .build()

        sRetrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        mRetrofit = Retrofit.Builder()
                .baseUrl(API_MOVIE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}