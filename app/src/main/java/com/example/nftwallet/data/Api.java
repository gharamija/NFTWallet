package com.example.nftwallet.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://min-api.cryptocompare.com/data/";

    @GET("price?fsym=ETH&tsyms=USD&api_key=30711a1f2429e179c512b2f3c414c65f5a7ac1dd63579157de2b973f6f1b7d56")
    Call<Model> getData();


}
