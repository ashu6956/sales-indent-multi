package com.agriscience.salesindent.model;

import com.google.gson.annotations.SerializedName;

public class STOIndentDetailsResponse {

	@SerializedName("dbm_approval_time")
	private Object dbmApprovalTime;

	@SerializedName("Material_description")
	private String materialDescription;

	@SerializedName("rbm_remarks")
	private String rbmRemarks;

	@SerializedName("Indent_time")
	private String indentTime;

	@SerializedName("Variety_code")
	private String varietyCode;

	@SerializedName("Sending_PlantName")
	private String sendingPlantName;

	@SerializedName("Rbm_no_of_pac")
	private String rbmNoOfPac;

	public String getPackingQuantity() {
		return packingQuantity;
	}

	public void setPackingQuantity(String packingQuantity) {
		this.packingQuantity = packingQuantity;
	}

	public String getBaseUom() {
		return baseUom;
	}

	public void setBaseUom(String baseUom) {
		this.baseUom = baseUom;
	}

	public String getrBM() {
		return rBM;
	}

	public void setrBM(String rBM) {
		this.rBM = rBM;
	}

	public String getsTOIndentNo() {
		return sTOIndentNo;
	}

	public void setsTOIndentNo(String sTOIndentNo) {
		this.sTOIndentNo = sTOIndentNo;
	}

	@SerializedName("packing_quantity")
	private String packingQuantity;

	@SerializedName("base_uom")
	private String baseUom;

	@SerializedName("Line_no")
	private String lineNo;

	@SerializedName("dbm_remarks")
	private String dbmRemarks;

	@SerializedName("Sending_plant")
	private String sendingPlant;

	@SerializedName("sales_division")
	private String salesDivision;

	@SerializedName("indent_date")
	private String indentDate;

	@SerializedName("Crop_code")
	private String cropCode;

	@SerializedName("Rbm_item_weight")
	private String rbmItemWeight;

	@SerializedName("Division")
	private String division;

	@SerializedName("sales_region_name")
	private String salesRegionName;

	@SerializedName("rbm_name")
	private String rbmName;

	@SerializedName("rbm_qty")
	private String rbmQty;

	@SerializedName("RBM")
	private String rBM;

	@SerializedName("dbm_item_weight")
	private Object dbmItemWeight;

	@SerializedName("dbm_name")
	private String dbmName;

	@SerializedName("recID")
	private String recID;

	@SerializedName("sales_division_name")
	private String salesDivisionName;

	@SerializedName("Final_status")
	private String finalStatus;

	@SerializedName("final_item_weight")
	private String finalItemWeight;

	@SerializedName("dbm_no_of_pac")
	private Object dbmNoOfPac;

	@SerializedName("dbm")
	private String dbm;

	@SerializedName("dbm_approval_date")
	private Object dbmApprovalDate;

	@SerializedName("Variety_name")
	private String varietyName;

	@SerializedName("dbm_qty")
	private Object dbmQty;

	@SerializedName("Receiving_plant")
	private String receivingPlant;

	@SerializedName("final_no_of_pac")
	private String finalNoOfPac;

	@SerializedName("Crop_name")
	private String cropName;

	@SerializedName("STO_indent_no")
	private String sTOIndentNo;

	@SerializedName("dbm_approval_status")
	private String dbmApprovalStatus;

	@SerializedName("Material_code")
	private String materialCode;

	@SerializedName("Final_quantity")
	private String finalQuantity;

	@SerializedName("Req_date")
	private String reqDate;

	@SerializedName("Sales_region")
	private String salesRegion;

	@SerializedName("Receiving_PlantName")
	private String receivingPlantName;

	public void setDbmApprovalTime(Object dbmApprovalTime){
		this.dbmApprovalTime = dbmApprovalTime;
	}

	public Object getDbmApprovalTime(){
		return dbmApprovalTime;
	}

	public void setMaterialDescription(String materialDescription){
		this.materialDescription = materialDescription;
	}

	public String getMaterialDescription(){
		return materialDescription;
	}

	public void setRbmRemarks(String rbmRemarks){
		this.rbmRemarks = rbmRemarks;
	}

	public String getRbmRemarks(){
		return rbmRemarks;
	}

	public void setIndentTime(String indentTime){
		this.indentTime = indentTime;
	}

	public String getIndentTime(){
		return indentTime;
	}

	public void setVarietyCode(String varietyCode){
		this.varietyCode = varietyCode;
	}

	public String getVarietyCode(){
		return varietyCode;
	}

	public void setSendingPlantName(String sendingPlantName){
		this.sendingPlantName = sendingPlantName;
	}

	public String getSendingPlantName(){
		return sendingPlantName;
	}

	public void setRbmNoOfPac(String rbmNoOfPac){
		this.rbmNoOfPac = rbmNoOfPac;
	}

	public String getRbmNoOfPac(){
		return rbmNoOfPac;
	}

	public void setLineNo(String lineNo){
		this.lineNo = lineNo;
	}

	public String getLineNo(){
		return lineNo;
	}

	public void setDbmRemarks(String dbmRemarks){
		this.dbmRemarks = dbmRemarks;
	}

	public String getDbmRemarks(){
		return dbmRemarks;
	}

	public void setSendingPlant(String sendingPlant){
		this.sendingPlant = sendingPlant;
	}

	public String getSendingPlant(){
		return sendingPlant;
	}

	public void setSalesDivision(String salesDivision){
		this.salesDivision = salesDivision;
	}

	public String getSalesDivision(){
		return salesDivision;
	}

	public void setIndentDate(String indentDate){
		this.indentDate = indentDate;
	}

	public String getIndentDate(){
		return indentDate;
	}

	public void setCropCode(String cropCode){
		this.cropCode = cropCode;
	}

	public String getCropCode(){
		return cropCode;
	}

	public void setRbmItemWeight(String rbmItemWeight){
		this.rbmItemWeight = rbmItemWeight;
	}

	public String getRbmItemWeight(){
		return rbmItemWeight;
	}

	public void setDivision(String division){
		this.division = division;
	}

	public String getDivision(){
		return division;
	}

	public void setSalesRegionName(String salesRegionName){
		this.salesRegionName = salesRegionName;
	}

	public String getSalesRegionName(){
		return salesRegionName;
	}

	public void setRbmName(String rbmName){
		this.rbmName = rbmName;
	}

	public String getRbmName(){
		return rbmName;
	}

	public void setRbmQty(String rbmQty){
		this.rbmQty = rbmQty;
	}

	public String getRbmQty(){
		return rbmQty;
	}

	public void setRBM(String rBM){
		this.rBM = rBM;
	}

	public String getRBM(){
		return rBM;
	}

	public void setDbmItemWeight(Object dbmItemWeight){
		this.dbmItemWeight = dbmItemWeight;
	}

	public Object getDbmItemWeight(){
		return dbmItemWeight;
	}

	public void setDbmName(String dbmName){
		this.dbmName = dbmName;
	}

	public String getDbmName(){
		return dbmName;
	}

	public void setRecID(String recID){
		this.recID = recID;
	}

	public String getRecID(){
		return recID;
	}

	public void setSalesDivisionName(String salesDivisionName){
		this.salesDivisionName = salesDivisionName;
	}

	public String getSalesDivisionName(){
		return salesDivisionName;
	}

	public void setFinalStatus(String finalStatus){
		this.finalStatus = finalStatus;
	}

	public String getFinalStatus(){
		return finalStatus;
	}

	public void setFinalItemWeight(String finalItemWeight){
		this.finalItemWeight = finalItemWeight;
	}

	public String getFinalItemWeight(){
		return finalItemWeight;
	}

	public void setDbmNoOfPac(Object dbmNoOfPac){
		this.dbmNoOfPac = dbmNoOfPac;
	}

	public Object getDbmNoOfPac(){
		return dbmNoOfPac;
	}

	public void setDbm(String dbm){
		this.dbm = dbm;
	}

	public String getDbm(){
		return dbm;
	}

	public void setDbmApprovalDate(Object dbmApprovalDate){
		this.dbmApprovalDate = dbmApprovalDate;
	}

	public Object getDbmApprovalDate(){
		return dbmApprovalDate;
	}

	public void setVarietyName(String varietyName){
		this.varietyName = varietyName;
	}

	public String getVarietyName(){
		return varietyName;
	}

	public void setDbmQty(Object dbmQty){
		this.dbmQty = dbmQty;
	}

	public Object getDbmQty(){
		return dbmQty;
	}

	public void setReceivingPlant(String receivingPlant){
		this.receivingPlant = receivingPlant;
	}

	public String getReceivingPlant(){
		return receivingPlant;
	}

	public void setFinalNoOfPac(String finalNoOfPac){
		this.finalNoOfPac = finalNoOfPac;
	}

	public String getFinalNoOfPac(){
		return finalNoOfPac;
	}

	public void setCropName(String cropName){
		this.cropName = cropName;
	}

	public String getCropName(){
		return cropName;
	}

	public void setSTOIndentNo(String sTOIndentNo){
		this.sTOIndentNo = sTOIndentNo;
	}

	public String getSTOIndentNo(){
		return sTOIndentNo;
	}

	public void setDbmApprovalStatus(String dbmApprovalStatus){
		this.dbmApprovalStatus = dbmApprovalStatus;
	}

	public String getDbmApprovalStatus(){
		return dbmApprovalStatus;
	}

	public void setMaterialCode(String materialCode){
		this.materialCode = materialCode;
	}

	public String getMaterialCode(){
		return materialCode;
	}

	public void setFinalQuantity(String finalQuantity){
		this.finalQuantity = finalQuantity;
	}

	public String getFinalQuantity(){
		return finalQuantity;
	}

	public void setReqDate(String reqDate){
		this.reqDate = reqDate;
	}

	public String getReqDate(){
		return reqDate;
	}

	public void setSalesRegion(String salesRegion){
		this.salesRegion = salesRegion;
	}

	public String getSalesRegion(){
		return salesRegion;
	}

	public void setReceivingPlantName(String receivingPlantName){
		this.receivingPlantName = receivingPlantName;
	}

	public String getReceivingPlantName(){
		return receivingPlantName;
	}

	@Override
 	public String toString(){
		return 
			"ResultItem{" + 
			"dbm_approval_time = '" + dbmApprovalTime + '\'' + 
			",material_description = '" + materialDescription + '\'' + 
			",rbm_remarks = '" + rbmRemarks + '\'' + 
			",indent_time = '" + indentTime + '\'' + 
			",variety_code = '" + varietyCode + '\'' + 
			",sending_PlantName = '" + sendingPlantName + '\'' + 
			",rbm_no_of_pac = '" + rbmNoOfPac + '\'' + 
			",line_no = '" + lineNo + '\'' + 
			",dbm_remarks = '" + dbmRemarks + '\'' + 
			",sending_plant = '" + sendingPlant + '\'' + 
			",sales_division = '" + salesDivision + '\'' + 
			",indent_date = '" + indentDate + '\'' + 
			",crop_code = '" + cropCode + '\'' + 
			",rbm_item_weight = '" + rbmItemWeight + '\'' + 
			",division = '" + division + '\'' + 
			",sales_region_name = '" + salesRegionName + '\'' + 
			",rbm_name = '" + rbmName + '\'' + 
			",rbm_qty = '" + rbmQty + '\'' + 
			",rBM = '" + rBM + '\'' + 
			",dbm_item_weight = '" + dbmItemWeight + '\'' + 
			",dbm_name = '" + dbmName + '\'' + 
			",recID = '" + recID + '\'' + 
			",sales_division_name = '" + salesDivisionName + '\'' + 
			",final_status = '" + finalStatus + '\'' + 
			",final_item_weight = '" + finalItemWeight + '\'' + 
			",dbm_no_of_pac = '" + dbmNoOfPac + '\'' + 
			",dbm = '" + dbm + '\'' + 
			",dbm_approval_date = '" + dbmApprovalDate + '\'' + 
			",variety_name = '" + varietyName + '\'' + 
			",dbm_qty = '" + dbmQty + '\'' + 
			",receiving_plant = '" + receivingPlant + '\'' + 
			",final_no_of_pac = '" + finalNoOfPac + '\'' + 
			",crop_name = '" + cropName + '\'' + 
			",sTO_indent_no = '" + sTOIndentNo + '\'' + 
			",dbm_approval_status = '" + dbmApprovalStatus + '\'' + 
			",material_code = '" + materialCode + '\'' + 
			",final_quantity = '" + finalQuantity + '\'' + 
			",req_date = '" + reqDate + '\'' + 
			",sales_region = '" + salesRegion + '\'' + 
			",receiving_PlantName = '" + receivingPlantName + '\'' + 
			"}";
		}
}