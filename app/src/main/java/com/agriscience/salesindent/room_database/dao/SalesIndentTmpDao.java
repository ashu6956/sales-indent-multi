package com.agriscience.salesindent.room_database.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.agriscience.salesindent.room_database.entity.SalesIndentDetailsTmpEntity;

import java.util.List;

@Dao
public interface SalesIndentTmpDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(SalesIndentDetailsTmpEntity... salesIndentDetailsTmps);

    @Query("Select * from SalesIndentDetailsTmpEntity")
    List<SalesIndentDetailsTmpEntity> getAllSalesIndentTmp();

    @Query("Delete from SalesIndentDetailsTmpEntity")
    void deleteAllSalesIndentTmpDetails();
}
