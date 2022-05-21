package com.example.nftwallet.database.Entities;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;


public class CollectionWithNFT {
    @Embedded
    public Collection collection;
    @Relation(
            parentColumn = "nftId",
            entityColumn = "collectionId",
            associateBy = @Junction(CollectionsAndNFT.class)
    )
    public List<NFT> nfts;
}