package com.example.nftwallet;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.nftwallet.adapters.CollectionListItemAdapter;
import com.example.nftwallet.database.CollectionDao;
import com.example.nftwallet.database.Entities.Collection;
import com.example.nftwallet.database.Entities.CollectionsAndNFT;
import com.example.nftwallet.database.Entities.NFT;
import com.example.nftwallet.database.NFTWalletDatabase;
import com.example.nftwallet.database.RepositoryDatabase;
import com.example.nftwallet.databinding.ActivityMainBinding;

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




        RecyclerView rv = findViewById(R.id.rv_collection_list_items);

        Log.d(TAG, String.valueOf(DB.collectionDao().getAll().size()));
        Log.d(TAG, "onCreateeeeeeeeeeeeeee: ");


        //List<CollectionWithNFT> collections = DB.collectionDao().getAll();
        //rv.setAdapter(new CollectionListItemAdapter(collections));

        DB.nFTDao().insertNFT(new NFT("bAJO","dESCRIPTION",1.0,"IMAGE URL",false));
        DB.collectionDao().insertCollection(new Collection("SuperCollection"));
        DB.collectionsAndNFT().insertCollectionAndNft(new CollectionsAndNFT(1,1));



        rv.setAdapter(new CollectionListItemAdapter(RepositoryDatabase.getCollectionWithNft(this.getApplicationContext())));

        rv.setOnClickListener(v -> {
            //TODO go to collection info
            Intent intent = new Intent(getApplicationContext(), AddCollectionActivity.class);
            startActivity(intent);
        });

    }

    private void setupDatabase() {
        DB = NFTWalletDatabase.getInstance(this.getApplicationContext());
    }


}