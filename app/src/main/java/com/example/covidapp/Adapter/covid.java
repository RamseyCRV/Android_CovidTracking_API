package com.example.covidapp.Adapter;

//import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.SerializedName;

public class covid {

    @SerializedName("Active Cases_text")
    private String active;

    @SerializedName("Country_text")
    private String country;

    @SerializedName("Last Update")
    private String lastUpdate;

    @SerializedName("New Cases_text")
    private String newCases;

    @SerializedName("New Deaths_text")
    private String newDeaths;

    @SerializedName("Total Cases_text")
    private String totalCases;

    @SerializedName("Total Deaths_text")
    private String totalDeaths;

    @SerializedName("Total Recovered_text")
    private String recovered;

    public covid() {
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getNewCases() {
        return newCases;
    }

    public void setNewCases(String newCases) {
        this.newCases = newCases;
    }

    public String getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(String newDeaths) {
        this.newDeaths = newDeaths;
    }

    public String getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(String totalCases) {
        this.totalCases = totalCases;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public covid(String active, String country, String lastUpdate, String newCases, String newDeaths, String totalCases, String totalDeaths, String recovered) {
        this.active = active;
        this.country = country;
        this.lastUpdate = lastUpdate;
        this.newCases = newCases;
        this.newDeaths = newDeaths;
        this.totalCases = totalCases;
        this.totalDeaths = totalDeaths;
        this.recovered = recovered;
    }
}