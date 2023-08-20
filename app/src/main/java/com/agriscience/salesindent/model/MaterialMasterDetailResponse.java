package com.agriscience.salesindent.model;

import com.google.gson.annotations.SerializedName;

public class MaterialMasterDetailResponse {

	@SerializedName("packing_quantity")
	private String packingQuantity;

	@SerializedName("message")
	private String message;

	@SerializedName("base_uom")
	private String baseUom;

	@SerializedName("material_name")
	private String materialName;

	@SerializedName("status")
	private String status;

	@SerializedName("variety_code")
	private String varietyCode;

	@SerializedName("variety_name")
	private String varietyName;

	@SerializedName("material_code")
	private String materialCode;

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

	@SerializedName("crop_code")
	private String cropCode;


	@SerializedName("crop_name")
	private String cropName;

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
		return "MaterialMasterDetailResponse{" +
				"packingQuantity='" + packingQuantity + '\'' +
				", message='" + message + '\'' +
				", baseUom='" + baseUom + '\'' +
				", materialName='" + materialName + '\'' +
				", status='" + status + '\'' +
				", varietyCode='" + varietyCode + '\'' +
				", varietyName='" + varietyName + '\'' +
				", materialCode='" + materialCode + '\'' +
				", cropCode='" + cropCode + '\'' +
				", cropName='" + cropName + '\'' +
				'}';
	}
}