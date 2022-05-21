package com.example.nftwallet.database.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CollectionsAndNFT")
public class CollectionsAndNFT {
    @PrimaryKey(autoGenerate = true)
    public Long id;

    @ColumnInfo(name = "nftId")
    public long nftId;

    @ColumnInfo(name = "collectionId")
    public long collectionId;

    public CollectionsAndNFT(long nftId, long collectionId) {
        this.nftId = nftId;
        this.collectionId = collectionId;
    }
}
