package com.example.nftwallet.data;

import com.google.gson.annotations.SerializedName;

public class Model {
    @SerializedName("USD")
    private Double USD;

    public Double getDollars() {
        return USD;
    }

    public void setDollars(Double USD) {
        this.USD = USD;
    }

}
