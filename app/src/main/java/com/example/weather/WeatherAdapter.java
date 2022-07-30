package com.example.weather;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.MyViewHolder> {

    // 4rt step view create
    Context context;

    List<DailyForecast.Day> days;
 WeatherAdapter(Context context, List<DailyForecast.Day> days){

     this.context = context;
     this.days = days;

 }



    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from ( context );
            View view =    inflater.inflate ( R.layout.weather_single_row, parent,false );
            MyViewHolder myViewHolder = new MyViewHolder ( view );


            return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

     // 6th step

        days.get ( position ).getDt ();
        Date date = new  Date ((long) (days.get ( position ).getDt ()) *1000);
        String dates = DateFormat.getDateTimeInstance ().format ( date );


        holder.data.setText (dates );
        holder.descrption.setText ( days.get ( position ).getWeather ().get ( 0 ).getDescription ()+"" );
        holder.wind.setText ( days.get ( position ).getDeg ()+"" );
        holder.pressure.setText ( days.get ( position ).getPressure ()+"" );
        holder.humidity.setText ( days.get ( position ).getHumidity ()+"" );

        DecimalFormat decimalFormat = new DecimalFormat ("#.#");
        String temp = decimalFormat.format ( (days.get ( position ).getTemp ().getDay ()) -273.15 );


        holder.temperature.setText ( temp);
        holder.tmax.setText ( days.get ( position ).getTemp ().getMax ().toString () );
        holder.tmin.setText ( days.get ( position ) .getTemp ().getMin ().toString ());


    }

    @Override
    public int getItemCount() {
        return days.size () ;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

     //5th step
  TextView data, descrption,wind, pressure, humidity, temperature, tmax, tmin;

        public MyViewHolder(@NonNull  View itemView) {
            super ( itemView );

            data =  itemView.findViewById ( R.id.data );
            descrption = itemView.findViewById ( R.id.description );
            wind = itemView.findViewById (R.id.wind );
            pressure = itemView.findViewById ( R.id.pressure );
            humidity = itemView.findViewById ( R.id.humadity );
            temperature = itemView.findViewById ( R.id.temperature );
            tmax = itemView.findViewById ( R.id.tmpx );
            tmin = itemView.findViewById ( R.id.tmin );

        }
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId ( position );
    }
}
