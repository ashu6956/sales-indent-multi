package com.agriscience.salesindent.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "sto_material")
public class STOMaterialDetailsResponse {

	@PrimaryKey(autoGenerate = true)
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@SerializedName("variety_name")
	@ColumnInfo
	private String varietyName;

	@SerializedName("crop_code")
	@ColumnInfo
	private String cropCode;

	@SerializedName("crop_name")
	@ColumnInfo
	private String cropName;

	@SerializedName("variety_code")
	@ColumnInfo
	private String varietyCode;

	@SerializedName("packing_quantity")
	@ColumnInfo
	private String packingQuantity;

	@SerializedName("base_uom")
	@ColumnInfo
	private String baseUom;

	@SerializedName("message")
	@ColumnInfo
	private String message;

	@SerializedName("material_name")
	@ColumnInfo
	private String materialName;

	@SerializedName("status")
	@ColumnInfo
	private String status;

	@SerializedName("material_code")
	@ColumnInfo
	private String materialCode;

	public void setVarietyName(String varietyName){
		this.varietyName = varietyName;
	}

	public String getVarietyName(){
		return varietyName;
	}

	public void setCropCode(String cropCode){
		this.cropCode = cropCode;
	}

	public String getCropCode(){
		return cropCode;
	}

	public void setCropName(String cropName){
		this.cropName = cropName;
	}

	public String getCropName(){
		return cropName;
	}

	public void setVarietyCode(String varietyCode){
		this.varietyCode = varietyCode;
	}

	public String getVarietyCode(){
		return varietyCode;
	}

	public void setPackingQuantity(String packingQuantity){
		this.packingQuantity = packingQuantity;
	}

	public String getPackingQuantity(){
		return packingQuantity;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setBaseUom(String baseUom){
		this.baseUom = baseUom;
	}

	public String getBaseUom(){
		return baseUom;
	}

	public void setMaterialName(String materialName){
		this.materialName = materialName;
	}

	public String getMaterialName(){
		return materialName;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setMaterialCode(String materialCode){
		this.materialCode = materialCode;
	}

	public String getMaterialCode(){
		return materialCode;
	}

	@Override
 	public String toString(){
		return 
			"AcsenMaterialMasterResItem{" + 
			"variety_name = '" + varietyName + '\'' + 
			",crop_code = '" + cropCode + '\'' + 
			",crop_name = '" + cropName + '\'' + 
			",variety_code = '" + varietyCode + '\'' + 
			",packing_quantity = '" + packingQuantity + '\'' + 
			",message = '" + message + '\'' + 
			",base_uom = '" + baseUom + '\'' + 
			",material_name = '" + materialName + '\'' + 
			",status = '" + status + '\'' + 
			",material_code = '" + materialCode + '\'' + 
			"}";
		}
}