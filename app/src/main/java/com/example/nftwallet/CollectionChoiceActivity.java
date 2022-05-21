package com.example.nftwallet;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nftwallet.adapters.CollectionListItemAdapter;
import com.example.nftwallet.adapters.NFTListItemAdapter;
import com.example.nftwallet.database.Entities.CollectionWithNFT;

import java.util.List;

public class CollectionChoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_choice);

        List<CollectionWithNFT> collectionWithNFTList = DataStorage.getCollections();

        RecyclerView rv = findViewById(R.id.collection_list_item_name);
        rv.setAdapter(new CollectionListItemAdapter(collectionWithNFTList));

    }
}
