package com.example.nftwallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.Visibility;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.nftwallet.data.Api;
import com.example.nftwallet.data.Model;
import com.example.nftwallet.data.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData = findViewById(R.id.getData);
        final Model[] oneETHtoDollars = {new Model()};
        Model dollars = new Model();

        Call<Model> modelCall = RetrofitClient.getInstance().getMyApi().getData();

        modelCall.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                oneETHtoDollars[0] = response.body();
                Log.e(TAG, "on response code: "+response.code());
                dollars.setUSD(response.body().getDollars());
                Log.e(TAG, "onResponse: " + response.body().getDollars());
            }
            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.e(TAG, "onFailure: "+ t.getMessage());
            }
        });

        System.out.println("Eth to dollars: " + oneETHtoDollars[0].getDollars());
        System.out.println("drugi pokusaj: " + dollars.getDollars());
//        getData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Call<Model> modelCall = RetrofitClient.getInstance().getMyApi().getData();
//
//                modelCall.enqueue(new Callback<Model>() {
//
//                    @Override
//                    public void onResponse(Call<Model> call, Response<Model> response) {
//                        Log.e(TAG, "on response code: "+response.code());
//                        Log.e(TAG, "onResponse: "+ response.body().getDollars());
//                    }
//
//                    @Override
//                    public void onFailure(Call<Model> call, Throwable t) {
//                        Log.e(TAG, "onFailure: "+ t.getMessage());
//                    }
//                });
//            }
//        });
    }
}