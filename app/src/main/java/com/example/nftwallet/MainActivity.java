package com.example.nftwallet;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.nftwallet.data.Api;
import com.example.nftwallet.data.FetchData;
import com.example.nftwallet.data.Model;
import com.example.nftwallet.data.PriceSingleton;
import com.example.nftwallet.data.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FetchData.getData();


    }


}