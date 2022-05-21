package com.example.nftwallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.nftwallet.adapters.CollectionListItemAdapter;
import com.example.nftwallet.adapters.NFTListItemAdapter;
import com.example.nftwallet.data.FetchData;
import com.example.nftwallet.data.PriceSingleton;
import com.example.nftwallet.database.Entities.CollectionWithNFT;
import com.example.nftwallet.database.Entities.NFT;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;

public class CollectionDisplayActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_display);

        // TODO: get CollectionWithNFT from DB
        CollectionWithNFT collectionWithNFT = DataStorage.getOneCollection();

        TextView collectionNameView = findViewById(R.id.name_collection);
        TextView ethPriceView = findViewById(R.id.collection_eth_value);
        TextView usdPriceView = findViewById(R.id.collection_usd_value);

        collectionNameView.setText(collectionWithNFT.collection.name);

        double totalEthPrice = 0.0;
        for(NFT nft : collectionWithNFT.nfts) {
            totalEthPrice += nft.price;
        }

        // Absolute disaster
        if (PriceSingleton.getInstance().getPriceInDollars() < 0) {
            FetchData.getData();
        }

        double totalUsdPrice = totalEthPrice * PriceSingleton.getInstance().getPriceInDollars();


        ethPriceView.setText(String.format(Locale.US, "%.4f ETH", totalEthPrice));
        usdPriceView.setText(String.format(Locale.US, "%.2f USD", totalUsdPrice));

        RecyclerView rv = findViewById(R.id.nft_list_items);
        for(NFT nft : DataStorage.NFTS) {
            Log.d("ACTIVITY", nft.imageUrl);
        }
        rv.setAdapter(new NFTListItemAdapter(getApplicationContext(), collectionWithNFT.nfts));

    }
}