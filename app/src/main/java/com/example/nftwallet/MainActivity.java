package com.example.nftwallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.nftwallet.data.Api;
import com.example.nftwallet.data.Model;
import com.example.nftwallet.data.RetrofitClient;
import com.example.nftwallet.database.Entities.NFT;
import com.example.nftwallet.database.NFTDao;
import com.example.nftwallet.database.NFTWalletDatabase;
import com.example.nftwallet.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button getData;

    //Acitivity binding
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        getData = findViewById(R.id.getData);
        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Model> modelCall = RetrofitClient.getInstance().getMyApi().getData();

                modelCall.enqueue(new Callback<Model>() {

                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        Log.e(TAG, "on response code: "+response.code());
                        Log.e(TAG, "onResponse: "+ response.body().getDollars());
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Log.e(TAG, "onFailure: "+ t.getMessage());
                    }
                });
            }
        });
    }
}