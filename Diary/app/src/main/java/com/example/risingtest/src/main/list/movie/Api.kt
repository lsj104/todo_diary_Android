package com.example.risingtest.src.main.list.movie

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("movie/popular")
    fun getPopularMovies(
            @Query("api_key") apiKey: String = "c9f6df2322d1e8838fcf6e446621efbe",
            @Query("page") page : Int,
            @Query("language") language : String = "ko,en-US"
    ): Call<GetMoviesResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(
            @Query("api_key") apiKey: String = "<< API KEY >>",
            @Query("page") page : Int,
            @Query("language") language : String = "ko,en-US"
    ): Call<GetMoviesResponse>

    @GET("movie/upcoming")
    fun getUpcomingMovies(
            @Query("api_key") apiKey: String = "<< API KEY >>",
            @Query("page") page : Int,
            @Query("language") language : String = "ko,en-US"
    ): Call<GetMoviesResponse>

    @GET("movie/now_playing")
    fun getNowPlayingMovies(
            @Query("api_key") apiKey: String = "<< API KEY >>",
            @Query("page") page : Int,
            @Query("language") language : String = "ko,en-US"
    ): Call<GetMoviesResponse>

    @GET("discover/movie")
    fun getDiscoverMovies(
            @Query("api_key") apiKey: String = "<< API KEY >>",
            @Query("page") page : Int,
            @Query("language") language : String = "ko,en-US"
    ): Call<GetMoviesResponse>
}