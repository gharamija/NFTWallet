package com.example.nftwallet.database;

import android.content.Context;
import android.os.Build;

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
        DB = NFTWalletDatabase.getInstance(context);

        List<Collection> collections = DB.collectionDao().getAll();
        List<NFT> nfts = DB.nFTDao().getAll();

        List<CollectionWithNFT> collectionWithNFTS;

        Map<Collection, List<NFT>> map = new HashMap<>();


        List<CollectionsAndNFT> collAndNft = DB.collectionsAndNFT().getAll();

        collAndNft.forEach(cn -> {

            //collection with that matches cn collection ID
            Collection cl = collections.stream().filter(c -> c.id.equals(cn.collectionId)).findAny().get();
            //nft that matches cn nft ID
            NFT nft = nfts.stream().filter(n -> n.id.equals(cn.nftId)).findAny().get();

            if (!map.containsKey(cl.id)) {
                map.put(cl, new ArrayList<NFT>());
            }
            try{map.get(cl.id).add(nft);}
            catch (Exception e){}

        });

       List<CollectionWithNFT> collection = new ArrayList<>();
       map.forEach((aLong, nfts1) -> {

           collection.add(new CollectionWithNFT(aLong,nfts1));
       });
        return collection;
    }
}
