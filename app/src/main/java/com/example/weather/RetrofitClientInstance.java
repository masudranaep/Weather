package com.example.weather;

import java.util.concurrent.atomic.AtomicReference;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static final String BASE_URL= "http://api.openweathermap.org";
 static Retrofit retrofit;

     static Retrofit getRetrofitInstance(){

      retrofit = new Retrofit.Builder ()
                .baseUrl ( BASE_URL )
                .addConverterFactory ( GsonConverterFactory.create () )
                .build () ;

      return retrofit;

      }



}
