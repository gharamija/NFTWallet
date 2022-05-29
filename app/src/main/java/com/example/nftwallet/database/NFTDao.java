package com.example.nftwallet.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.nftwallet.database.Entities.NFT;

import java.util.List;

import retrofit2.http.DELETE;

@Dao
public interface NFTDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNFT(NFT nft);

    @Query("SELECT * FROM NFT")
    List<NFT> getAll();

    @Delete
    void deleteNFT(NFT nft);

    @Query("DELETE FROM NFT WHERE id == :nftId")

    void deleteById(Long nftId);

    @Query("DELETE FROM NFT")
    void deleteAll();
}


