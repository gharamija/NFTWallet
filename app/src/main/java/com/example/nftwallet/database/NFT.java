package com.example.nftwallet.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

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
    @ColumnInfo(name = "collections")
    public List<Collection> collections;

    public NFT(Long id, String name, String description, Double price, String imageUrl, Boolean sold, List<Collection> collections) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.sold = sold;
        this.collections = collections;
    }
}
