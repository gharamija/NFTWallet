package com.example.nftwallet;

import static android.content.ContentValues.TAG;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.nftwallet.adapters.CollectionListItemAdapter;
import com.example.nftwallet.adapters.NFTListItemAdapter;
import com.example.nftwallet.data.FetchData;
import com.example.nftwallet.data.PriceSingleton;
import com.example.nftwallet.database.Entities.Collection;
import com.example.nftwallet.database.Entities.CollectionWithNFT;
import com.example.nftwallet.database.Entities.CollectionsAndNFT;
import com.example.nftwallet.database.Entities.NFT;
import com.example.nftwallet.database.NFTWalletDatabase;
import com.example.nftwallet.database.RepositoryDatabase;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CollectionDisplayActivity extends AppCompatActivity {

    private CollectionWithNFT collectionWithNFT;

    private NFTWalletDatabase DB;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_display);

        setupScreen();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onResume() {
        super.onResume();
        setupScreen();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setupScreen() {
        Bundle bundleData = getIntent().getExtras();


        collectionWithNFT =
                RepositoryDatabase.getNftsFromCollectionId(Integer.parseInt(bundleData.get("id").toString())
                        , this.getApplicationContext());



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

        rv.setAdapter(new NFTListItemAdapter(getApplicationContext(), collectionWithNFT.nfts,collectionWithNFT.collection));

        handleDeleteButton();
    }

    private void handleDeleteButton() {
        if (collectionWithNFT.collection.name.equals("All NFT's")){
            View button = findViewById(R.id.fab_delete);

            button.setEnabled(false);
            button.setVisibility(View.INVISIBLE);
        }
    }

    public void onClickFloatingButton(View view) {
        Intent intent = new Intent(getApplicationContext(),AddNFTActivity.class);


        intent.putExtra("collectionId",collectionWithNFT.collection.id.toString());
        intent.putExtra("collectionName",collectionWithNFT.collection.name);



        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClickFloatingButtonDelete(View view) {
         DB = NFTWalletDatabase.getInstance(this.getApplicationContext());

        List<Long> listOfNftIds = collectionWithNFT.nfts.stream().map(n -> n.id).collect(Collectors.toList());

        DB.collectionsAndNFT().deleteByCollectionId(collectionWithNFT.collection.id);
        DB.collectionDao().deleteCollection(collectionWithNFT.collection);


        this.finish();
    }
}