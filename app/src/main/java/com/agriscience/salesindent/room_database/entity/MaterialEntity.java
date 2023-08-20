package com.agriscience.salesindent.room_database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity (tableName = "material_entity")
public class MaterialEntity {


    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name= "packing_quantity")
    private String packingQuantity;

    @ColumnInfo(name= "message")
    private String message;

    @ColumnInfo(name= "base_uom")
    private String baseUom;

    @ColumnInfo(name= "material_name")
    private String materialName;

    @ColumnInfo(name= "variety_code")
    private String varietyCode;

    public String getCropCode() {
        return cropCode;
    }

    public void setCropCode(String cropCode) {
        this.cropCode = cropCode;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    @ColumnInfo(name= "variety_name")
    private String varietyName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnInfo(name = "crop_code")
    private String cropCode;

    @ColumnInfo(name = "crop_name")
    private String cropName;

    @ColumnInfo(name= "status")
    private String status;

    @ColumnInfo(name= "material_code")
    private String materialCode;

    public String getPackingQuantity() {
        return packingQuantity;
    }

    public String getMessage() {
        return message;
    }

    public void setPackingQuantity(String packingQuantity) {
        this.packingQuantity = packingQuantity;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setBaseUom(String baseUom) {
        this.baseUom = baseUom;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMaterialCode(@NonNull String materialCode) {
        this.materialCode = materialCode;
    }

    public String getBaseUom() {
        return baseUom;
    }

    public String getMaterialName() {
        return materialName;
    }

    public String getStatus() {
        return status;
    }

    @NonNull
    public String getMaterialCode() {
        return materialCode;
    }

    public String getVarietyCode() {
        return varietyCode;
    }

    public void setVarietyCode(String varietyCode) {
        this.varietyCode = varietyCode;
    }

    public String getVarietyName() {
        return varietyName;
    }

    public void setVarietyName(String varietyName) {
        this.varietyName = varietyName;
    }

    @Override
    public String toString() {
        return "MaterialEntity{" +
                "packingQuantity='" + packingQuantity + '\'' +
                ", message='" + message + '\'' +
                ", baseUom='" + baseUom + '\'' +
                ", materialName='" + materialName + '\'' +
                ", varietyCode='" + varietyCode + '\'' +
                ", varietyName='" + varietyName + '\'' +
                ", cropCode='" + cropCode + '\'' +
                ", cropName='" + cropName + '\'' +
                ", status='" + status + '\'' +
                ", materialCode='" + materialCode + '\'' +
                '}';
    }
}
