package com.example.nftwallet.data;

public class Model {
    private String USD;

    public Model() {
        USD = null;
    }

    public Model(String USD) {
        this.USD = USD;
    }

    public void setUSD(String USD) {
        this.USD = USD;
    }

    public String getDollars() {
        return USD;
    }

}
