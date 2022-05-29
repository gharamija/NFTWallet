package com.example.nftwallet.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.example.nftwallet.database.Entities.CollectionsAndNFT;

import java.util.List;

@Dao
public interface CollectionAndNFTDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCollectionAndNft(CollectionsAndNFT collectionsAndNFT);

    @Delete
    void deleteCollectionAndNft(CollectionsAndNFT collectionsAndNFT);

    @Query("SELECT * FROM CollectionsAndNFT")
    List<CollectionsAndNFT> getAll();

    @Query("DELETE FROM CollectionsAndNFT")
    void deleteAll();

    @Query("DELETE FROM CollectionsAndNFT WHERE nftId==:nftId")
    void deleteByNftId(long nftId);

    @Query("DELETE FROM CollectionsAndNFT WHERE collectionId == :collectionid")
    void deleteByCollectionId(Long collectionid);
}
