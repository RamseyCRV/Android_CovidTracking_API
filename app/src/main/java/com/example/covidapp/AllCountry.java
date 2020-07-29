package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.covidapp.Adapter.covid;
import com.example.covidapp.Adapter.covidAdapter;
import com.example.covidapp.CovidApi.CovidApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AllCountry extends AppCompatActivity {

    private ListView listView;
    private com.example.covidapp.Adapter.covidAdapter covidAdapter;
    private CovidApi covidApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_country_activity);

        listView = (ListView) findViewById(R.id.list_view_all_country);

        retrofitBase();
        getAllCountry();
    }

    private void retrofitBase() {
        Gson gson = new GsonBuilder().serializeNulls().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://covid-19-tracking.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create(gson)).build();

        covidApi = retrofit.create(CovidApi.class);

    }

    private void getAllCountry() {
        Call<List<covid>> call = covidApi.getInfo(CovidApi.Key);
        call.enqueue(new Callback<List<covid>>() {

            @Override
            public void onResponse(Call<List<covid>> call, Response<List<covid>> response) {

                if (!response.isSuccessful()){
                    return;
                }

                List<covid> covids = response.body();

                covidAdapter = new covidAdapter((ArrayList<covid>) covids, getApplicationContext());
                listView.setAdapter(covidAdapter);

            }

            @Override
            public void onFailure(Call<List<covid>> call, Throwable t) {
                Toast.makeText(AllCountry.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

}