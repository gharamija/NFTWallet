package com.example.nftwallet.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.nftwallet.database.Entities.NFT;

import java.util.List;

@Dao
public interface NFTDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNFT(NFT nft);

    @Query("SELECT * FROM NFT")
    LiveData<List<NFT>> getAll();

    @Delete
    void deleteNFT(NFT nft);
}


