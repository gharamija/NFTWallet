package com.example.nftwallet.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.nftwallet.database.Entities.Collection;
import com.example.nftwallet.database.Entities.CollectionsAndNFT;
import com.example.nftwallet.database.Entities.NFT;

@Database(
        version = 1,
        entities = {
                NFT.class,
                Collection.class,
                CollectionsAndNFT.class
        }
)
public abstract class NFTWalletDatabase extends RoomDatabase {
    public abstract NFTDao nFTDao();
    public abstract CollectionDao collectionDao();
    public abstract CollectionWithNFTDao collectionWithNFTDao();

    private static NFTWalletDatabase INSTANCE;

    public static NFTWalletDatabase getInstance(Context context) {
        if (INSTANCE==null)
        {
            INSTANCE = Room.databaseBuilder(context,
                            NFTWalletDatabase.class, "NFT_database")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
