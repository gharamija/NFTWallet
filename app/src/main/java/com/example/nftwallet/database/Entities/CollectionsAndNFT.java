package com.example.nftwallet.database.Entities;

import androidx.room.Entity;


@Entity(primaryKeys = {"nftId", "collectionId"})
public class CollectionsAndNFT {
    public long nftId;
    public long collectionId;
}
