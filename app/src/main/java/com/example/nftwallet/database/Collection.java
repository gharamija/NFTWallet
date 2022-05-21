package com.example.nftwallet.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "Collection")
public class Collection {


    @PrimaryKey(autoGenerate = true)
    public Long id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "NFTs")
    public List<NFT> NFTs;

    public Collection(Long id, String name) {
        this.id = id;
        this.name = name;
    }

//+ getAll(): List<Collection>
//+ getOne(): Collection
}
