package com.example.nftwallet.data;

public class PriceSingleton {
    private static PriceSingleton instance = null;
    private Double priceInDollars;

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
