package com.example.nftwallet.data;

public class PriceSingleton {
    private static PriceSingleton instance = null;
    private Double priceInDollars = -1.0;

    public static  PriceSingleton getInstance() {
        if (instance == null) {
            instance = new PriceSingleton();
        }
        return instance;
    }

    public Double getPriceInDollars() {
        return priceInDollars;
    }

    public void setPriceInDollars(Double priceInDollars) {
        this.priceInDollars = priceInDollars;
    }
}
