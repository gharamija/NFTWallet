package com.example.nftwallet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.nftwallet.data.ImageLoadTask;
import com.example.nftwallet.database.Entities.NFT;
import com.example.nftwallet.database.NFTWalletDatabase;

import java.util.List;

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

    private String nameFromPrevActvty = "Ime";
    private String titleFromPrevActvty;
    private String descriptionFromPrevActvty;
    private String priceETHFromPrevActvty;
    private String imageFromPrevActvty;

    private NFTWalletDatabase DB;

    private void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.nft_menu, popup.getMenu());
        popup.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item, String itemId) {
        int id = item.getItemId();
        DB = NFTWalletDatabase.getInstance(this.getApplicationContext());
        List<NFT> all = DB.nFTDao().getAll();
        Boolean soldFromPrevActvty = false;
        double priceFrom = 0;
        for(NFT single : all) {
            if(single.name.equals(nameFromPrevActvty)) {
                priceFrom = single.price;
                imageFromPrevActvty = single.imageUrl;
                descriptionFromPrevActvty = single.description;
                soldFromPrevActvty = single.sold;
                break;
            }
        }
        NFT novi = new NFT(nameFromPrevActvty, descriptionFromPrevActvty,
                priceFrom, imageFromPrevActvty, soldFromPrevActvty);

        if (id == R.id.update) {
            Intent intent = new Intent(getApplicationContext(), CollectionChoiceActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.delete) {
            DB.nFTDao().deleteNFT(novi);
            finish());
            return true;
        }


        return super.onOptionsItemSelected(item);
    }



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DB = NFTWalletDatabase.getInstance(this.getApplicationContext());

        setContentView(R.layout.acitivity_nftview);
        backButton = findViewById(R.id.back_button);
        tripleDotButton = findViewById(R.id.triple_dot_button);
        image = findViewById(R.id.nft_image);
        name = findViewById(R.id.nft_name);
        price = findViewById(R.id.nft_price);
        description = findViewById(R.id.nft_description);
        backButton.setOnClickListener(v ->
                finish());

        tripleDotButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showPopup(v);
            }
        });

        List<NFT> all = DB.nFTDao().getAll();

        //pull name from previous activity
        Intent intent = getIntent();
        //nameFromPrevActvty = intent.getExtras().getString("nameSharing");

        for(NFT single : all) {
            if(single.name.equals(nameFromPrevActvty)) {
                priceETHFromPrevActvty = single.price + " Eth";
                imageFromPrevActvty = single.imageUrl;
                descriptionFromPrevActvty = single.description;
                break;
            }
        }
        name.setText(nameFromPrevActvty);
        price.setText(priceETHFromPrevActvty);
        description.setText(descriptionFromPrevActvty);

        //image from imageUrl
        image = findViewById(R.id.nft_image);
        new ImageLoadTask(imageFromPrevActvty, image).execute();

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