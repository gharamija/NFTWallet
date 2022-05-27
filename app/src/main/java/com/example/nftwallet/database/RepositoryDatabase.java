package com.example.nftwallet.database;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.nftwallet.database.Entities.Collection;
import com.example.nftwallet.database.Entities.CollectionWithNFT;
import com.example.nftwallet.database.Entities.CollectionsAndNFT;
import com.example.nftwallet.database.Entities.NFT;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryDatabase {

    private static NFTWalletDatabase DB;
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<CollectionWithNFT> getCollectionWithNft(Context context) {
        //database init
        DB = NFTWalletDatabase.getInstance(context);

        List<Collection> collections = DB.collectionDao().getAll();

        List<NFT> nfts = DB.nFTDao().getAll();

        List<CollectionsAndNFT> collAndNft = DB.collectionsAndNFT().getAll();



        Map<Collection, List<NFT>> map = new HashMap<>();

        collAndNft.forEach(cn -> {

            //collection with that matches cn collection ID
            Collection cl = collections.stream().filter(c -> c.id.equals(cn.collectionId)).findAny().get();
            //nft that matches cn nft ID
            NFT nft = nfts.stream().filter(n -> n.id.equals(cn.nftId)).findAny().get();


            if (!map.containsKey(cl)) {
                map.put(cl, new ArrayList<NFT>());
            }
            map.get(cl).add(nft);



        });

        //The list we will return
        List<CollectionWithNFT> collectionWithNFT = new ArrayList<>();


        //add to collectionWithNFT all CollectionWithNFT that contain nft's
        map.forEach((col, nft) -> {
            collections.remove(col);
            collectionWithNFT.add(new CollectionWithNFT(col,nft));

        });

        //add to collectionWithNFT other CollectionWithNFT that does NOT contain nft's
        collections.forEach(c -> {collectionWithNFT.add(new CollectionWithNFT(c,new ArrayList<>()));});

        return collectionWithNFT;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static CollectionWithNFT getNftsFromCollectionId (int idCollection, Context context){

              return getCollectionWithNft(context)
                .stream()
                .filter(cn -> cn.collection.id == idCollection).findAny().get();

    }
}
