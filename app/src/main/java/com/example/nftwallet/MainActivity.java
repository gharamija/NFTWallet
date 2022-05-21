package com.example.nftwallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


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




    }
}