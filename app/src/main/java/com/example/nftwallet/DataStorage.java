package com.example.nftwallet;

import com.example.nftwallet.database.Entities.Collection;
import com.example.nftwallet.database.Entities.CollectionWithNFT;
import com.example.nftwallet.database.Entities.NFT;
import com.example.nftwallet.database.NFTWalletDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataStorage {

    public static final List<NFT> NFTS = Arrays.asList(
            new NFT("Crypto Punker", "aa", 1200.0, "https://lh3.googleusercontent.com/40zXeV2KcirN32V8cmfQRoKQYXUMXUYpN2CJW3nj8UgNMOJbG5NO6rV8JWrL2pvBNwKs-Hr3lt4B3Mbw3QklpjyQK9k28R7ZdAR3IQ=w345", false),
            new NFT("Ilija Muskic", "ba", 2.0, "https://lh3.googleusercontent.com/BxS1uoYaoZYCwj8V6-iP5A_uMafqj7AwUzx4tanqBwnKWM8wGaWEuNoV_Sko6A-RvZflWHupbjUTuO5zy2wWaBD4MKLTofwaQc6M2uM=w510", false),
            new NFT("Mark Cukerberg", "ca", 0.0, "https://lh3.googleusercontent.com/gVqI7uD_syQr5U29HZNmIBS1jNv9M0vlUzdjRIWoitrFRtl6A0vTH60NUozn_PGtr4ABXWOZrYiNhx7CIA96yI0aJYiy9c6AeIHSBA=w510", false),
            new NFT("Nikola Tesla", "da", 3.0, "https://lh3.googleusercontent.com/46x3Qw7N3xiP1lObvXDpMyGQXr1j3F-Bheqr-HreRbV5bRsSRUqLkzFl8EFiSoxDzYOH4Me0j3VxStUjfzv6P6qx9W5xoh39fDQ33p4=w495", false),
            new NFT("Anto Dapic", "ea", 0.1, "https://lh3.googleusercontent.com/bazqcQ5HiDlzoiijOZ27O1lL-BuNtS9v8FQnD4IPEA9n44whqoyuzzo45gM9mjD3Td1swglKjuTY8dLsf6pPR-t2gyolgbBdvmm_ig=w495", false),
            new NFT("Josko Cagalj", "fa", 120.0, "https://lh3.googleusercontent.com/uTNtvzTskJfj86HMk16tOXQSQlxwTTtNntiHFHDFo3Ba6jEHjxqNadjQJ55_s2t6kszEZbqO78Ld1GpJkQZRWP3zTh4UaVHJYGiJuOc=w495", false),
            new NFT("Sinisa Vuco", "ga", 60.0, "https://lh3.googleusercontent.com/546ZBzxhsuPGOMQySxGfYsb3tsHVtkxDANHK3bGkuxJiaNUqw2NGzpL-k3C0PDXOzZHZEAldRyNvWGQsWAj_tDkJ2Afl0EuABukPOw=w495", false),
            new NFT("Don Kacunko", "ha", 12.0, "https://lh3.googleusercontent.com/aOWshK9zZ2xR_sLpiPhu0CNIoepSbKRC0Th3rvmScb9VAmGHN5o_NOlLmzoKSH3Hez-XpDji5_LOc1zrNQcNta_iWJxCvsjRBhHEXBo=w495", false),
            new NFT("Jala I Buba", "ia", 1.0, "https://lh3.googleusercontent.com/1Dx5TLPgGm_QlWFqzlEAIMQjPSe5YBjTVFfOakb-Z_s9rOmtIVnEZ_Afqg6dF5UW8qX-Aild8uoHcbYc4u_mCvlDHgRanS6R_SRHsQ=w495", false)
    );

    public static final List<Collection> COLLECTIONS = Arrays.asList(
            new Collection("svi"),
            new Collection("neki"),
            new Collection("najbolji")
    );

    public static List<CollectionWithNFT> getCollections() {
        CollectionWithNFT col_nft_1 = new CollectionWithNFT();
        CollectionWithNFT col_nft_2 = new CollectionWithNFT();
        CollectionWithNFT col_nft_3 = new CollectionWithNFT();

        col_nft_1.collection = COLLECTIONS.get(0);
        col_nft_2.collection = COLLECTIONS.get(1);
        col_nft_3.collection = COLLECTIONS.get(2);

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
