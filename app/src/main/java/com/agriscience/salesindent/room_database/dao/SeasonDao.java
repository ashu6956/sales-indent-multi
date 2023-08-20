package com.agriscience.salesindent.room_database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.agriscience.salesindent.room_database.entity.SeasonEntity;

import java.util.List;

@Dao
public interface SeasonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(SeasonEntity... seasonEntities);

    @Query("Select * from season_entity")
    List<SeasonEntity> getAllSeasons();

    @Query("Select * from season_entity where season_code = :seasonCode and crop_code=:cropCode and state=:stateId")
    SeasonEntity  getSeasonBySeasonCode(String seasonCode,String cropCode,String stateId);

    @Query("Delete from season_entity")
    void deleteAllSeasonDetails();

    @Query("Select * from season_entity where crop_code =:cropCode and state=:stateId")
    List<SeasonEntity> getAllSeasonDetailsFilterByCropCodeAndStateId(String cropCode,String stateId);
}
