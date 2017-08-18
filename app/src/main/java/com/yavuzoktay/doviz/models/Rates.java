package com.yavuzoktay.doviz.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rates {

    @SerializedName("GBP")
    @Expose
    public Float gBP;
    @SerializedName("USD")
    @Expose
    public Float uSD;
    @SerializedName("EUR")
    @Expose
    public Float eUR;

    public Rates withGBP(Float gBP) {
        this.gBP = gBP;
        return this;
    }

    public Rates withUSD(Float uSD) {
        this.uSD = uSD;
        return this;
    }

    public Rates withEUR(Float eUR) {
        this.eUR = eUR;
        return this;
    }

}