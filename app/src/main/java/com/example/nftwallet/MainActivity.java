package com.example.nftwallet;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.nftwallet.adapters.CollectionListItemAdapter;
import com.example.nftwallet.database.CollectionDao;
import com.example.nftwallet.database.Entities.Collection;
import com.example.nftwallet.database.Entities.CollectionWithNFT;
import com.example.nftwallet.database.Entities.CollectionsAndNFT;
import com.example.nftwallet.database.Entities.NFT;
import com.example.nftwallet.database.NFTWalletDatabase;
import com.example.nftwallet.database.RepositoryDatabase;
import com.example.nftwallet.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    //Acitivity binding
   private ActivityMainBinding binding;

    private CollectionDao collectionDao;

    private NFTWalletDatabase DB;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);


        setupDatabase();
        setupScreen();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setupScreen() {
        setupRecyclerView();
        setupButtons();
    }

    private void setupButtons() {
        View button = findViewById(R.id.main_activity_button_1);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),AddNFTActivity.class);
            startActivity(intent);
        });


        View button2 = findViewById(R.id.main_activity_button_2);

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),AddCollectionActivity.class);
            startActivity(intent);
        });
    }

    private void openCollectionDetails(CollectionWithNFT collectionWithNFT){

        Intent intent = new Intent(getApplicationContext(), CollectionDisplayActivity.class);


        intent.putExtra("id",collectionWithNFT.collection.id);

        startActivity(intent);
        return;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setupRecyclerView() {
        List<CollectionWithNFT> data = RepositoryDatabase.getCollectionWithNft(this.getApplicationContext());

        RecyclerView rv = findViewById(R.id.rv_collection_list_items);

        CollectionListItemAdapter collectionListAdapter = new CollectionListItemAdapter(data);
        collectionListAdapter.setOnClickListener(this::openCollectionDetails);

        rv.setAdapter(collectionListAdapter);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setupDatabase() {
        DB = NFTWalletDatabase.getInstance(this.getApplicationContext());
        handleMainCollection();
    }

    //Create Main collection (All nft's collection) if it dosent exists
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void handleMainCollection() {
        List<Collection> collections = DB.collectionDao().getAll();

        Optional<Collection> AllNftsCollection = collections.stream().filter(c -> c.name.equals("All NFT's")).findAny();
        if (!AllNftsCollection.isPresent()){
            DB.collectionDao().insertCollection(new Collection("All NFT's"));
        }
    }


}