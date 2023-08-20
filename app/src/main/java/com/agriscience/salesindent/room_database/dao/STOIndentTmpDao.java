package com.agriscience.salesindent.room_database.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.agriscience.salesindent.room_database.entity.STOIndentTmpEntity;

import java.util.List;

@Dao
public interface STOIndentTmpDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(STOIndentTmpEntity... stoIndentTmpEntities);

    @Query("Select * from STOIndentTmpEntity")
    List<STOIndentTmpEntity> getAllSTOIndentTmp();

    @Query("Delete from STOIndentTmpEntity")
    void deleteAllSTOIndentTmpDetails();
}
