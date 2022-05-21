package com.example.nftwallet.database.Entities;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;


public class CollectionWithNFT {

    public Collection collection;

    public List<NFT> nfts;

    public CollectionWithNFT(Collection collection, List<NFT> nfts) {
        this.collection = collection;
        this.nfts = nfts;
    }




}