package com.kei.moviecatalogue.network

import com.kei.moviecatalogue.model.movie.MovieUpcomingItemResponse
import com.kei.moviecatalogue.model.movie.PopularResponse
import com.kei.moviecatalogue.model.tv.TvPopularResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getPopular(
            @Query("api_key") apiKey : String,
            @Query("page") page : Int
    ): retrofit2.Call<PopularResponse>
    @GET("movie/upcoming")
    fun getUpcoming(
            @Query("api_key") apiKey : String,
            @Query("page") page : Int
    ): retrofit2.Call<MovieUpcomingItemResponse>
    @GET ("tv/Popular")
    fun getTvPopular(
        @Query("api_key") apiKey : String,
        @Query("page") page : Int
    ): retrofit2.Call<TvPopularResponse>
}