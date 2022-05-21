package com.example.nftwallet.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.nftwallet.database.Entities.NFT;

@Dao
public interface NFTDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNFT(NFT nft);

    @Delete
    void deleteNFT(NFT nft);
}


