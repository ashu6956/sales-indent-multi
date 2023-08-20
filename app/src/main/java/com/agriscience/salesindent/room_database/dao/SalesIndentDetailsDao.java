package com.agriscience.salesindent.room_database.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.agriscience.salesindent.room_database.entity.SalesIndentRequestDetailsEntity;

import java.util.List;

@Dao
public interface SalesIndentDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(com.agriscience.salesindent.room_database.entity.SalesIndentRequestDetailsEntity... salesIndentRequestDetailsEntities);

    @Query("Select * from SalesIndentRequestDetailsEntity")
    List<com.agriscience.salesindent.room_database.entity.SalesIndentRequestDetailsEntity> getAllSalesIndentRequestDetails();

    @Query("Delete from SalesIndentRequestDetailsEntity")
    void deleteAllSalesIndentRequestDetails();
}
