package com.agriscience.salesindent.room_database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.agriscience.salesindent.room_database.entity.MaterialEntity;

import java.util.List;

@Dao
public interface MaterialDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(MaterialEntity... materialEntities);

    @Query("Select * from material_entity")
    List<MaterialEntity> getAllCropDetails();

    @Query("Select * from material_entity where crop_name=:cropName")
    List<MaterialEntity> getAllVarietyDetails(String cropName);

    @Query("Select * from material_entity where crop_name=:cropName and variety_name=:varietyName")
    List<MaterialEntity> getAllItemNameDetails(String cropName,String varietyName);

    @Query("Select * from material_entity where material_name =:materialName")
    MaterialEntity getMaterialEntityDetails(String materialName);

    @Query("Select DISTINCT crop_code from material_entity where crop_name = :cropName")
    String getCropCodeByCropName(String cropName);


    @Query("Select DISTINCT variety_code from material_entity where variety_name = :varietyName")
    String getVarietyCodeByVarietyName(String varietyName);


    @Query("Select DISTINCT material_code from material_entity where material_name = :materialName")
    String getItemCodeByItemName(String materialName);

    @Query("Select DISTINCT base_uom from material_entity where material_name = :materialName")
    String getBaseUOMByItemName(String materialName);

    @Query("Select DISTINCT packing_quantity from material_entity where material_name = :materialName")
    String getPackingQuantityByItemName(String materialName);

    @Query("Delete from material_entity where material_name = :materialName")
    void deleteMaterialDetailsByMaterialName(String materialName);


    @Query("Delete from material_entity")
    void deleteAllMaterialDetails();
}
