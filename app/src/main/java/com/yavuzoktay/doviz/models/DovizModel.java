package com.yavuzoktay.doviz.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DovizModel {

    @SerializedName("base")
    @Expose
    public String base;
    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("rates")
    @Expose
    public Rates rates;

    public DovizModel withBase(String base) {
        this.base = base;
        return this;
    }

    public DovizModel withDate(String date) {
        this.date = date;
        return this;
    }

    public DovizModel withRates(Rates rates) {
        this.rates = rates;
        return this;
    }

}