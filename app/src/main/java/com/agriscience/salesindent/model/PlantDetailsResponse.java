package com.agriscience.salesindent.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;


@Entity(tableName = "plant_details")
public class PlantDetailsResponse {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @SerializedName("Sales")
    @ColumnInfo
    private String sales;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @SerializedName("Plant_code")
    @ColumnInfo
    private String plantCode;

    @SerializedName("Plant_name")
    @ColumnInfo
    private String plantName;

    @ColumnInfo
    @SerializedName("Processing")
    private String processing;

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getSales() {
        return sales;
    }

    public void setPlantCode(String plantCode) {
        this.plantCode = plantCode;
    }

    public String getPlantCode() {
        return plantCode;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setProcessing(String processing) {
        this.processing = processing;
    }

    public String getProcessing() {
        return processing;
    }

    @Override
    public String toString() {
        return
                "PlantResponseItem{" +
                        "sales = '" + sales + '\'' +
                        ",plant_code = '" + plantCode + '\'' +
                        ",plant_name = '" + plantName + '\'' +
                        ",processing = '" + processing + '\'' +
                        "}";
    }
}