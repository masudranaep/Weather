package com.example.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public abstract class DataServices {

    //end url
    //api.openweathermap.org/data/2.5/forecast/daily?q=München,DE&appid={API key}

    @GET("data/2.5/forecast/daily")
    abstract Call<DailyForecast> getDailyForecast(@Query("q") String city, @Query("appid") String apikey, @Query("cnt") int cnt);


}

