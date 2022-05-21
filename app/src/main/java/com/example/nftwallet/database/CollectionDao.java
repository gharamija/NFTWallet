package com.example.nftwallet.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.nftwallet.database.Entities.Collection;
import com.example.nftwallet.database.Entities.CollectionWithNFT;
import java.util.List;

@Dao
public interface CollectionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCollection(Collection collection);

    @Delete
    void deleteCollection(Collection collection);

    @Query("SELECT * FROM Collection")
    List<Collection> getAll();
}
