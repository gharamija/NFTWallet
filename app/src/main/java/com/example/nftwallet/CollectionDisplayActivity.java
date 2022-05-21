package com.example.nftwallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nftwallet.adapters.CollectionListItemAdapter;
import com.example.nftwallet.database.Entities.CollectionWithNFT;

import java.util.List;

public class CollectionDisplayActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_display);

    }
}