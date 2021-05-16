package com.example.baitap_lab08_android_tuan8;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NameDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Name name);

    @Query("DELETE FROM name_table")
    void deleteAll();

    @Query("SELECT * FROM name_table ORDER BY name ASC")
    LiveData<List<Name>> getAlphabetizedNames();
}
