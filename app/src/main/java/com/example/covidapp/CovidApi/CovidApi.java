package com.example.covidapp.CovidApi;

import com.example.covidapp.Adapter.covid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CovidApi {

    final static public String Key = "e4c4defcadmshe786c6293e74aafp1feae4jsn29a39e808d27";

    @GET("v1")
    Call<List<covid>> getInfo(@Query("rapidapi-key") String rapidKey);

    @GET("v1/{country}")
    Call<covid> getCountryInfo(@Path("country") String countryName, @Query("rapidapi-key") String rapidKey);
}
