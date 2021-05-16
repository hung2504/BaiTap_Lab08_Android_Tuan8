package com.example.baitap_lab08_android_tuan8;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "name_table")
public class Name {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String mName;

    public Name(@NonNull String name){
        this.mName = name;
    }

    @NonNull
    public String getmName() {
        return mName;
    }
}
