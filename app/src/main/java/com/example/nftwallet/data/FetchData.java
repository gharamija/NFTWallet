package com.example.nftwallet.data;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchData {
    private static final String TAG = "MainActivity";
    public static void getData() {
        Call<Model> modelCall = RetrofitClient.getInstance().getMyApi().getData();

        modelCall.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                System.out.println("response: " + response.code() + "\n" + " response 2: " + response.body().getDollars());
                PriceSingleton.getInstance().setPriceInDollars(response.body().getDollars());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.e(TAG, "onFailure: "+ t.getMessage());
            }
        });
    }
}
