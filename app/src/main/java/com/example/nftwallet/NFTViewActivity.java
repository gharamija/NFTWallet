package com.example.nftwallet;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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

    private String idFromPrevActvty;
    private String nameFromPrevActvty = "Ime";
    private String titleFromPrevActvty;
    private String descriptionFromPrevActvty;
    private String priceETHFromPrevActvty;
    private String imageFromPrevActvty;

    private NFTWalletDatabase DB;

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this::onOptionsItemSelected);

        MenuInflater inflater = popup.getMenuInflater();

        inflater.inflate(R.menu.nft_menu, popup.getMenu());
        popup.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean onOptionsItemSelected(MenuItem item) {
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
           // Intent intent = new Intent(getApplicationContext(), CollectionChoiceActivity.class);
           // startActivity(intent);
            return true;
        }

        if (id == R.id.delete) {
            Log.d(TAG, "onOptionsItemSelected: ");
            Log.d(TAG, idFromPrevActvty); //19

            DB.collectionsAndNFT().deleteByNftId(Long.getLong(idFromPrevActvty));
            DB.nFTDao().deleteById(Long.getLong(idFromPrevActvty));

            finish();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupDatabase();
        setupScreen();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setupScreen() {

        setContentView(R.layout.acitivity_nftview);

        backButton = findViewById(R.id.back_button);
        tripleDotButton = findViewById(R.id.triple_dot_button);
        image = findViewById(R.id.nft_image);
        name = findViewById(R.id.nft_name);
        price = findViewById(R.id.nft_price);
        description = findViewById(R.id.nft_description);
        backButton.setOnClickListener(v ->
                finish());

        tripleDotButton.setOnClickListener(this::showPopup);



        //pull name from previous activity
        Intent intent = getIntent();
        Bundle bundleData = intent.getExtras();
        idFromPrevActvty = bundleData.get("id").toString();
        nameFromPrevActvty=  bundleData.get("name").toString();
        descriptionFromPrevActvty = bundleData.get("description").toString();
        priceETHFromPrevActvty = bundleData.get("price").toString() + " Eth";
        imageFromPrevActvty = bundleData.get("image").toString();

        name.setText(nameFromPrevActvty);
        price.setText(priceETHFromPrevActvty);
        description.setText(descriptionFromPrevActvty);
        image.setImageBitmap(BitmapFactory.decodeFile(imageFromPrevActvty));


    }

    private void setupDatabase() {
        DB = NFTWalletDatabase.getInstance(this.getApplicationContext());
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