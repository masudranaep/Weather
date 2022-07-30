package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

     RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        recyclerView = findViewById ( R.id.RV );


         Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance ();
       DataServices dataServices = retrofit.create (DataServices.class );

        Call<DailyForecast> call =  dataServices.getDailyForecast ( "Dhaka", "2e8804f487cc2dbd174af4cc5c0c02e7", 7 );


       call.enqueue ( new Callback<DailyForecast> () {
           @Override
           public void onResponse(Call<DailyForecast> call, Response<DailyForecast> response) {

               if(response.isSuccessful ()){

                   // 7th step
                   DailyForecast dailyForecast = response.body ();
                   List<DailyForecast.Day> days =  dailyForecast.getList ();

                   WeatherAdapter weatherAdapter = new WeatherAdapter ( MainActivity.this, days );
                   recyclerView.setAdapter ( weatherAdapter );

                   LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( MainActivity.this );
                   linearLayoutManager.setOrientation ( LinearLayoutManager.VERTICAL );
                   recyclerView.setLayoutManager ( linearLayoutManager );



                  // Toast.makeText ( MainActivity.this,response.body ().getCity ().getName (), Toast.LENGTH_LONG ).show ();
               }else
                   Toast.makeText ( MainActivity.this, " Somthing Wrong Plz try aging ", Toast.LENGTH_LONG ).show ();
           }

           @Override
           public void onFailure(Call<DailyForecast> call, Throwable t) {
                Toast.makeText ( MainActivity.this,"Faild", Toast.LENGTH_LONG ).show ();
           }
       } );
    }
}