package com.example.nftwallet.database.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;


@Entity(tableName = "Collection")
public class Collection {

    @PrimaryKey(autoGenerate = true)
    public Long id;
    @ColumnInfo(name = "name")
    public String name;

    public Collection(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Collection)) return false;
        Collection that = (Collection) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
