package com.example.nftwallet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NFTViewActivity extends AppCompatActivity {

    public static Intent newIntent(@NonNull Context context) {
        return new Intent(context, NFTDisplayActivity.class);
    }

    private Button backButton;
    private Button tripleDotButton;
    private ImageView image;
    private TextView name;
    private TextView price;
    private TextView description;
    

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_nftview);
        backButton = findViewById(R.id.back_button);
        tripleDotButton = findViewById(R.id.triple_dot_button);
        backButton.setOnClickListener(v ->
                finish());

        //tripleDotButton.setOnClickListener();
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onDestroy() {
        super.onDestroy();
        backButton = null;
        tripleDotButton = null;
        image = null;
        name = null;
        price = null;
        description = null;
    }

}