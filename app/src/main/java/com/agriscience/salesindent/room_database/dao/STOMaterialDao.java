package com.agriscience.salesindent.room_database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.agriscience.salesindent.model.STOMaterialDetailsResponse;

import java.util.List;

@Dao
public interface STOMaterialDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(STOMaterialDetailsResponse... materialDetailsResponses);

    @Query("Select * from sto_material")
    List<STOMaterialDetailsResponse> getAllSTOMaterialDetails();

    @Query("Select * from sto_material where cropName=:cropName")
    List<STOMaterialDetailsResponse> getAllVarietyDetailsByCropName(String cropName);


    @Query("Select * from sto_material where cropName=:cropName and varietyName=:varietyName")
    List<STOMaterialDetailsResponse> getAllItemNameDetails(String cropName,String varietyName);

    @Query("Select * from sto_material where materialName =:materialName")
    STOMaterialDetailsResponse getMaterialEntityDetails(String materialName);



    @Query("Select DISTINCT varietyCode from sto_material where varietyName = :varietyName")
    String getVarietyCodeByVarietyName(String varietyName);

    @Query("Select DISTINCT cropCode from sto_material where cropName = :cropName")
    String getCropCodeByCropName(String cropName);

    @Query("Select DISTINCT materialCode from sto_material where materialName = :materialName")
    String getItemCodeByItemName(String materialName);

    @Query("Select DISTINCT baseUom from sto_material where materialName = :materialName")
    String getBaseUOMByItemName(String materialName);

    @Query("Select DISTINCT packingQuantity from sto_material where materialName = :materialName")
    String getPackingQuantityByItemName(String materialName);

    @Query("Delete from sto_material where materialName = :materialName")
    void deleteMaterialDetailsByMaterialName(String materialName);


    @Query("Delete from sto_material")
    void deleteAllMaterialDetails();
}
