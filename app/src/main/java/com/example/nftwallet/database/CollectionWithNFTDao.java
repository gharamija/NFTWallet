package com.example.nftwallet.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.nftwallet.database.Entities.CollectionsAndNFT;

@Dao
public interface CollectionWithNFTDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CollectionsAndNFT collectionsAndNFT);


    @Delete
    void delete(CollectionsAndNFT collectionsAndNFT);
}
