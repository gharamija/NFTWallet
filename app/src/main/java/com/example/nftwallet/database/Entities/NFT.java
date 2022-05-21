package com.example.nftwallet.database.Entities;

import android.service.autofill.FillEventHistory;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "NFT")
public class NFT {

    @PrimaryKey(autoGenerate = true)
    public Long id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "description")
    public String description;
    @ColumnInfo(name = "price")
    public Double price;
    @ColumnInfo(name = "image_url")
    public String imageUrl;
    @ColumnInfo(name = "sold")
    public Boolean sold;

    public NFT(String name, String description, Double price, String imageUrl, Boolean sold) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.sold = sold;
    }
}
