package com.example.nftwallet.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.nftwallet.database.Entities.Collection;

@Dao
public interface CollectionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCollection(Collection collection);

    @Delete
    void deleteCollection(Collection collection);


}
