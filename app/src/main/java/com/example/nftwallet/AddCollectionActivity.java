package com.example.nftwallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nftwallet.database.CollectionDao;
import com.example.nftwallet.database.Entities.Collection;
import com.example.nftwallet.database.NFTWalletDatabase;

public class AddCollectionActivity extends AppCompatActivity implements View.OnClickListener {

    private String textInput;
    private NFTWalletDatabase database;
    private Button button;
    private TextView writtenText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_collection);
        button = findViewById(R.id.save_button);
        writtenText = findViewById(R.id.input_text);
        button.setOnClickListener(this);

    }

    private void setupDatabase(){
        database = NFTWalletDatabase.getInstance(this.getApplicationContext());
        database.collectionDao().insertCollection(new Collection(this.textInput));
    }

    @Override
    public void onClick(View v) {
        textInput = writtenText.getText().toString();
        setupDatabase();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}