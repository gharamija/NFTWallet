package com.example.nftwallet.database.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "Collection")
public class Collection {


    @PrimaryKey(autoGenerate = true)
    public Long id;
    @ColumnInfo(name = "name")
    public String name;


    public Collection(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Collection(String name) {
        this.name = name;
    }

    //+ getAll(): List<Collection>
//+ getOne(): Collection
}
