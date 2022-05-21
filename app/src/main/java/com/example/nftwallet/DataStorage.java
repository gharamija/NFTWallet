package com.example.nftwallet;

import com.example.nftwallet.database.Entities.Collection;
import com.example.nftwallet.database.Entities.CollectionWithNFT;
import com.example.nftwallet.database.Entities.NFT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataStorage {

    public static final List<NFT> NFTS = Arrays.asList(
            new NFT(1L, "a", "aa", 12.0, "", false),
            new NFT(2L, "b", "ba", 12.0, "", false),
            new NFT(3L, "c", "ca", 12.0, "", false),
            new NFT(4L, "d", "da", 12.0, "", false),
            new NFT(5L, "e", "ea", 12.0, "", false),
            new NFT(6L, "f", "fa", 12.0, "", false),
            new NFT(7L, "g", "ga", 12.0, "", false),
            new NFT(8L, "h", "ha", 12.0, "", false),
            new NFT(9L, "i", "ia", 12.0, "", false)
    );



    public static List<CollectionWithNFT> getCollections() {
        Collection col_1 = new Collection(1L, "svi");
        Collection col_2 = new Collection(2L, "neki");
        Collection col_3 = new Collection(3L, "najbolji");

        CollectionWithNFT col_nft_1 = new CollectionWithNFT();
        CollectionWithNFT col_nft_2 = new CollectionWithNFT();
        CollectionWithNFT col_nft_3 = new CollectionWithNFT();

        col_nft_1.collection = col_1;
        col_nft_2.collection = col_2;
        col_nft_3.collection = col_3;

        col_nft_1.nfts = new ArrayList<NFT>();
        col_nft_2.nfts = new ArrayList<NFT>();
        col_nft_3.nfts = new ArrayList<NFT>();

        col_nft_1.nfts.add(NFTS.get(0));
        col_nft_1.nfts.add(NFTS.get(1));
        col_nft_1.nfts.add(NFTS.get(2));
        col_nft_2.nfts.add(NFTS.get(3));
        col_nft_2.nfts.add(NFTS.get(4));
        col_nft_2.nfts.add(NFTS.get(5));
        col_nft_3.nfts.add(NFTS.get(6));
        col_nft_3.nfts.add(NFTS.get(7));
        col_nft_3.nfts.add(NFTS.get(8));

        return Arrays.asList(col_nft_1, col_nft_2, col_nft_3);

    }

}
