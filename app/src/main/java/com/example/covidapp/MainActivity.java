package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.covidapp.Adapter.covid;
import com.example.covidapp.CovidApi.CovidApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button btn_seeAllStates;
    private TextView tv_lastUpdate, tv_countryName, tv_totalCases, tv_totalDeaths, tv_totalRecovered, tv_newCases, tv_newDeaths, tv_activeCases;
    private EditText ed_searchCountry;
    private ImageView iw_search;
    private CovidApi covidApi;
    private String country = "world";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_seeAllStates = (Button) findViewById(R.id.button_search_country);
        tv_lastUpdate = (TextView) findViewById(R.id.textview_last_update);
        tv_countryName = (TextView) findViewById(R.id.textview_country_name);
        tv_totalDeaths = (TextView) findViewById(R.id.textview_total_deaths);
        tv_totalCases = (TextView) findViewById(R.id.textview_total_cases);
        tv_totalRecovered = (TextView) findViewById(R.id.textview_total_recovered);
        tv_newDeaths = (TextView) findViewById(R.id.textview_new_deaths);
        tv_newCases = (TextView) findViewById(R.id.textview_new_cases);
        tv_activeCases = (TextView) findViewById(R.id.textview_active_cases);
        ed_searchCountry = (EditText) findViewById(R.id.editText_search_country);
        iw_search = (ImageView) findViewById(R.id.imageView_search_country);


        retrofitBase();
        getCountryInfo();

        btn_seeAllStates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllCountry.class);
                startActivity(intent);
            }
        });

        iw_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                country = ed_searchCountry.getText().toString();
                getCountryInfo();
            }
        });

    }

    private void retrofitBase() {
        Gson gson = new GsonBuilder().serializeNulls().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://covid-19-tracking.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create(gson)).build();

        covidApi = retrofit.create(CovidApi.class);

    }

    private void getCountryInfo() {

        Call<covid> call = covidApi.getCountryInfo(country, CovidApi.Key);
        call.enqueue(new Callback<covid>() {

            @Override
            public void onResponse(Call<covid> call, Response<covid> response) {

                if (!response.isSuccessful()) {
                    return;
                }

                covid covids = response.body();

                tv_countryName.setText(covids.getCountry());
                tv_activeCases.setText("Active Cases: " + covids.getActive());
                tv_lastUpdate.setText("Last Update: " + covids.getLastUpdate());
                tv_totalCases.setText("Total Cases: " + covids.getTotalCases());
                tv_totalDeaths.setText("Total Deaths: " + covids.getTotalDeaths());
                tv_totalRecovered.setText("Recovered: " + covids.getRecovered());
                tv_newCases.setText("New Cases: " + covids.getNewCases());
                tv_newDeaths.setText("New Deaths: " + covids.getNewDeaths());

            }

            @Override
            public void onFailure(Call<covid> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}