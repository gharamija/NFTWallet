package com.example.nftwallet.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.nftwallet.database.Entities.CollectionWithNFT;
import com.example.nftwallet.database.Entities.CollectionsAndNFT;

import java.util.List;

@Dao
public interface CollectionWithNFTDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CollectionsAndNFT collectionsAndNFT);

    @Delete
    void delete(CollectionsAndNFT collectionsAndNFT);

    @Transaction
    @Query("SELECT * FROM Collection")
    public List<CollectionWithNFT> getCollectionsWithNfts();

}
