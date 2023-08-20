package com.agriscience.salesindent.room_database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import com.agriscience.salesindent.model.PlantDetailsResponse;

@Dao
public interface PlantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(PlantDetailsResponse... plantDetailsResponses);

    @Query("Select * from plant_details")
    List<PlantDetailsResponse>  getAllPlantDetails();

    @Query("Select * from plant_details where plantCode = :plantCode")
    PlantDetailsResponse getPlantByPlantCode(String plantCode);

    @Query("Delete from plant_details where plantCode = :plantCode")
    void deletePlantByPlantCode(String plantCode);


    @Query("Delete from plant_details")
    void deleteAllPlantData();

}
