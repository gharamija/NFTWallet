package com.example.nftwallet;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.nftwallet.adapters.CollectionListItemAdapter;
import com.example.nftwallet.data.Api;
import com.example.nftwallet.data.FetchData;
import com.example.nftwallet.data.Model;
import com.example.nftwallet.data.PriceSingleton;
import com.example.nftwallet.data.RetrofitClient;
import com.example.nftwallet.database.CollectionDao;
import com.example.nftwallet.database.Entities.CollectionWithNFT;
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

    //Acitivity binding
//    private ActivityMainBinding binding;
//    private ListView collectionListView;

    private CollectionDao collectionDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FetchData.getData();


        List<CollectionWithNFT> collectionWithNFTList = DataStorage.getCollections();

        // setupDatabase();
        // setupRecyclerView();

        RecyclerView rv = findViewById(R.id.rv_collection_list_items);
        rv.setAdapter(new CollectionListItemAdapter(collectionWithNFTList));

    }


    /*
    private void setupDatabase() {
        collectionDao = NFTApp.DB.collectionDao();
    }
    */
}