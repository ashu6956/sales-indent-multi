package com.agriscience.salesindent.model;

import com.google.gson.annotations.SerializedName;

public class SalesIndentStatusDetailsResponse {

	@SerializedName("rbm_approved_date")
	private Object rbmApprovedDate;

	@SerializedName("sales_division_id")
	private String salesDivisionId;

	@SerializedName("customer_state_id")
	private String customerStateId;

	@SerializedName("division")
	private String division;

	@SerializedName("dbm_id")
	private Object dbmId;

	@SerializedName("ti_quantity")
	private String tiQuantity;

	@SerializedName("dbm_quantity")
	private Object dbmQuantity;

	@SerializedName("packing_quantity")
	private String packingQuantity;

	@SerializedName("rbm_approval_status")
	private String rbmApprovalStatus;

	@SerializedName("rbm_name")
	private String rbmName;

	@SerializedName("customer_code")
	private String customerCode;

	@SerializedName("season_end_date")
	private String seasonEndDate;

	@SerializedName("dbm_name")
	private Object dbmName;

	@SerializedName("territory_id")
	private String territoryId;

	@SerializedName("sale_organization")
	private String saleOrganization;

	@SerializedName("crop_code")
	private String cropCode;

	@SerializedName("required_quantity_in_kgs")
	private String requiredQuantityInKgs;

	@SerializedName("dbm_approved_time")
	private Object dbmApprovedTime;

	@SerializedName("delivery_line_item")
	private String deliveryLineItem;

	@SerializedName("sales_region_id")
	private String salesRegionId;

	@SerializedName("distribution_channel")
	private String distributionChannel;

	@SerializedName("ti_id")
	private String tiId;

	@SerializedName("quantity_in_kgs_or_packets")
	private String quantityInKgsOrPackets;

	@SerializedName("indent_time")
	private String indentTime;

	@SerializedName("dbm_approved_date")
	private String dbmApprovedDate;

	@SerializedName("rbm_remarks")
	private String rbmRemarks;

	@SerializedName("indent_overall_status")
	private String indentOverallStatus;

	@SerializedName("crop_name")
	private String cropName;

	@SerializedName("territory_name")
	private String territoryName;

	@SerializedName("varity_code")
	private String varityCode;

	@SerializedName("base_uom")
	private String baseUom;

	@SerializedName("dbm_remarks")
	private String dbmRemarks;

	@SerializedName("Plant")
	private String plant;

	@SerializedName("no_of_packets_required")
	private String noOfPacketsRequired;

	@SerializedName("indent_date")
	private String indentDate;

	@SerializedName("sales_region_name")
	private String salesRegionName;

	@SerializedName("line_item_no")
	private String lineItemNo;

	@SerializedName("material_name")
	private String materialName;

	@SerializedName("ti_remarks")
	private String tiRemarks;

	@SerializedName("sales_division_name")
	private String salesDivisionName;

	@SerializedName("delivery")
	private String delivery;

	@SerializedName("quantity")
	private String quantity;

	@SerializedName("return_cut_off_date")
	private String returnCutOffDate;

	@SerializedName("indent_no")
	private String indentNo;

	@SerializedName("rbm_approved_time")
	private String rbmApprovedTime;

	@SerializedName("invoice_line_item")
	private String invoiceLineItem;

	@SerializedName("varity_name")
	private String varityName;

	@SerializedName("sales_office")
	private String salesOffice;

	@SerializedName("season_code")
	private String seasonCode;

	@SerializedName("season_starting_date")
	private String seasonStartingDate;

	@SerializedName("rbm_quantity")
	private String rbmQuantity;

	@SerializedName("ti_name")
	private String tiName;

	@SerializedName("dbm_approval_status")
	private String dbmApprovalStatus;


	@SerializedName("am_approval_status")
	private String amApprovalStatus;

	public String getAmRemarks() {
		return amRemarks;
	}

	public void setAmRemarks(String amRemarks) {
		this.amRemarks = amRemarks;
	}

	@SerializedName("am_remarks")
	private String amRemarks;

	public void setDbmApprovedTime(Object dbmApprovedTime) {
		this.dbmApprovedTime = dbmApprovedTime;
	}

	public String getAmApprovalStatus() {
		return amApprovalStatus;
	}

	public void setAmApprovalStatus(String amApprovalStatus) {
		this.amApprovalStatus = amApprovalStatus;
	}

	@SerializedName("customer_name")
	private String customerName;

	@SerializedName("sales_order")
	private String salesOrder;

	@SerializedName("invoice")
	private String invoice;

	@SerializedName("rbm_id")
	private String rbmId;

	@SerializedName("so_line_item")
	private String soLineItem;

	@SerializedName("material_code")
	private String materialCode;

	@SerializedName("recID")
	private String recID;


	public void setRbmApprovedDate(Object rbmApprovedDate){
		this.rbmApprovedDate = rbmApprovedDate;
	}

	public Object getRbmApprovedDate(){
		return rbmApprovedDate;
	}

	public void setSalesDivisionId(String salesDivisionId){
		this.salesDivisionId = salesDivisionId;
	}

	public String getSalesDivisionId(){
		return salesDivisionId;
	}

	public void setCustomerStateId(String customerStateId){
		this.customerStateId = customerStateId;
	}

	public String getCustomerStateId(){
		return customerStateId;
	}

	public void setDivision(String division){
		this.division = division;
	}

	public String getDivision(){
		return division;
	}

	public void setDbmId(Object dbmId){
		this.dbmId = dbmId;
	}

	public Object getDbmId(){
		return dbmId;
	}

	public void setTiQuantity(String tiQuantity){
		this.tiQuantity = tiQuantity;
	}

	public String getTiQuantity(){
		return tiQuantity;
	}

	public void setDbmQuantity(Object dbmQuantity){
		this.dbmQuantity = dbmQuantity;
	}

	public Object getDbmQuantity(){
		return dbmQuantity;
	}

	public void setPackingQuantity(String packingQuantity){
		this.packingQuantity = packingQuantity;
	}

	public String getPackingQuantity(){
		return packingQuantity;
	}

	public void setRbmApprovalStatus(String rbmApprovalStatus){
		this.rbmApprovalStatus = rbmApprovalStatus;
	}

	public String getRbmApprovalStatus(){
		return rbmApprovalStatus;
	}

	public void setRbmName(String rbmName){
		this.rbmName = rbmName;
	}

	public String getRbmName(){
		return rbmName;
	}

	public void setCustomerCode(String customerCode){
		this.customerCode = customerCode;
	}

	public String getCustomerCode(){
		return customerCode;
	}

	public void setSeasonEndDate(String seasonEndDate){
		this.seasonEndDate = seasonEndDate;
	}

	public String getSeasonEndDate(){
		return seasonEndDate;
	}

	public void setDbmName(Object dbmName){
		this.dbmName = dbmName;
	}

	public Object getDbmName(){
		return dbmName;
	}

	public void setTerritoryId(String territoryId){
		this.territoryId = territoryId;
	}

	public String getTerritoryId(){
		return territoryId;
	}

	public void setSaleOrganization(String saleOrganization){
		this.saleOrganization = saleOrganization;
	}

	public String getSaleOrganization(){
		return saleOrganization;
	}

	public void setCropCode(String cropCode){
		this.cropCode = cropCode;
	}

	public String getCropCode(){
		return cropCode;
	}

	public void setRequiredQuantityInKgs(String requiredQuantityInKgs){
		this.requiredQuantityInKgs = requiredQuantityInKgs;
	}

	public String getRequiredQuantityInKgs(){
		return requiredQuantityInKgs;
	}

	public void setDbmApprovedTime(String dbmApprovedTime){
		this.dbmApprovedTime = dbmApprovedTime;
	}

	public Object getDbmApprovedTime(){
		return dbmApprovedTime;
	}

	public void setDeliveryLineItem(String deliveryLineItem){
		this.deliveryLineItem = deliveryLineItem;
	}

	public String getDeliveryLineItem(){
		return deliveryLineItem;
	}

	public void setSalesRegionId(String salesRegionId){
		this.salesRegionId = salesRegionId;
	}

	public String getSalesRegionId(){
		return salesRegionId;
	}

	public void setDistributionChannel(String distributionChannel){
		this.distributionChannel = distributionChannel;
	}

	public String getDistributionChannel(){
		return distributionChannel;
	}

	public void setTiId(String tiId){
		this.tiId = tiId;
	}

	public String getTiId(){
		return tiId;
	}

	public void setQuantityInKgsOrPackets(String quantityInKgsOrPackets){
		this.quantityInKgsOrPackets = quantityInKgsOrPackets;
	}

	public String getQuantityInKgsOrPackets(){
		return quantityInKgsOrPackets;
	}

	public void setIndentTime(String indentTime){
		this.indentTime = indentTime;
	}

	public String getIndentTime(){
		return indentTime;
	}

	public void setDbmApprovedDate(String dbmApprovedDate){
		this.dbmApprovedDate = dbmApprovedDate;
	}

	public String getDbmApprovedDate(){
		return dbmApprovedDate;
	}

	public void setRbmRemarks(String rbmRemarks){
		this.rbmRemarks = rbmRemarks;
	}

	public String getRbmRemarks(){
		return rbmRemarks;
	}

	public void setIndentOverallStatus(String indentOverallStatus){
		this.indentOverallStatus = indentOverallStatus;
	}

	public String getIndentOverallStatus(){
		return indentOverallStatus;
	}

	public void setCropName(String cropName){
		this.cropName = cropName;
	}

	public String getCropName(){
		return cropName;
	}

	public void setTerritoryName(String territoryName){
		this.territoryName = territoryName;
	}

	public String getTerritoryName(){
		return territoryName;
	}

	public void setVarityCode(String varityCode){
		this.varityCode = varityCode;
	}

	public String getVarityCode(){
		return varityCode;
	}

	public void setBaseUom(String baseUom){
		this.baseUom = baseUom;
	}

	public String getBaseUom(){
		return baseUom;
	}

	public void setDbmRemarks(String dbmRemarks){
		this.dbmRemarks = dbmRemarks;
	}

	public String getDbmRemarks(){
		return dbmRemarks;
	}

	public void setPlant(String plant){
		this.plant = plant;
	}

	public String getPlant(){
		return plant;
	}

	public Object getNoOfPacketsRequired(){
		return noOfPacketsRequired;
	}

	public void setIndentDate(String indentDate){
		this.indentDate = indentDate;
	}

	public String getIndentDate(){
		return indentDate;
	}

	public void setSalesRegionName(String salesRegionName){
		this.salesRegionName = salesRegionName;
	}

	public String getSalesRegionName(){
		return salesRegionName;
	}

	public void setLineItemNo(String lineItemNo){
		this.lineItemNo = lineItemNo;
	}

	public String getLineItemNo(){
		return lineItemNo;
	}

	public void setMaterialName(String materialName){
		this.materialName = materialName;
	}

	public String getMaterialName(){
		return materialName;
	}

	public void setTiRemarks(String tiRemarks){
		this.tiRemarks = tiRemarks;
	}

	public String getTiRemarks(){
		return tiRemarks;
	}

	public void setSalesDivisionName(String salesDivisionName){
		this.salesDivisionName = salesDivisionName;
	}

	public String getSalesDivisionName(){
		return salesDivisionName;
	}

	public void setDelivery(String delivery){
		this.delivery = delivery;
	}

	public Object getDelivery(){
		return delivery;
	}

	public void setQuantity(String quantity){
		this.quantity = quantity;
	}

	public Object getQuantity(){
		return quantity;
	}

	public void setReturnCutOffDate(String returnCutOffDate){
		this.returnCutOffDate = returnCutOffDate;
	}

	public String getReturnCutOffDate(){
		return returnCutOffDate;
	}

	public void setIndentNo(String indentNo){
		this.indentNo = indentNo;
	}

	public String getIndentNo(){
		return indentNo;
	}

	public void setRbmApprovedTime(String rbmApprovedTime){
		this.rbmApprovedTime = rbmApprovedTime;
	}

	public Object getRbmApprovedTime(){
		return rbmApprovedTime;
	}

	public void setInvoiceLineItem(String invoiceLineItem){
		this.invoiceLineItem = invoiceLineItem;
	}

	public Object getInvoiceLineItem(){
		return invoiceLineItem;
	}

	public void setVarityName(String varityName){
		this.varityName = varityName;
	}

	public String getVarityName(){
		return varityName;
	}

	public void setSalesOffice(String salesOffice){
		this.salesOffice = salesOffice;
	}

	public Object getSalesOffice(){
		return salesOffice;
	}

	public void setSeasonCode(String seasonCode){
		this.seasonCode = seasonCode;
	}

	public String getSeasonCode(){
		return seasonCode;
	}

	public void setSeasonStartingDate(String seasonStartingDate){
		this.seasonStartingDate = seasonStartingDate;
	}

	public Object getSeasonStartingDate(){
		return seasonStartingDate;
	}

	public void setRbmQuantity(String rbmQuantity){
		this.rbmQuantity = rbmQuantity;
	}

	public Object getRbmQuantity(){
		return rbmQuantity;
	}

	public void setTiName(String tiName){
		this.tiName = tiName;
	}

	public String getTiName(){
		return tiName;
	}

	public void setDbmApprovalStatus(String dbmApprovalStatus){
		this.dbmApprovalStatus = dbmApprovalStatus;
	}

	public String  getDbmApprovalStatus(){
		return dbmApprovalStatus;
	}

	public void setCustomerName(String customerName){
		this.customerName = customerName;
	}

	public String getCustomerName(){
		return customerName;
	}

	public void setSalesOrder(String salesOrder){
		this.salesOrder = salesOrder;
	}

	public Object getSalesOrder(){
		return salesOrder;
	}

	public void setInvoice(String  invoice){
		this.invoice = invoice;
	}

	public Object getInvoice(){
		return invoice;
	}

	public void setRbmId(String rbmId){
		this.rbmId = rbmId;
	}

	public String getRbmId(){
		return rbmId;
	}

	public void setSoLineItem(String  soLineItem){
		this.soLineItem = soLineItem;
	}

	public Object getSoLineItem(){
		return soLineItem;
	}

	public void setMaterialCode(String materialCode){
		this.materialCode = materialCode;
	}

	public String getMaterialCode(){
		return materialCode;
	}

	public void setNoOfPacketsRequired(String noOfPacketsRequired) {
		this.noOfPacketsRequired = noOfPacketsRequired;
	}

	public String getRecID() {
		return recID;
	}

	public void setRecID(String recID) {
		this.recID = recID;
	}

	@Override
	public String toString() {
		return "SalesIndentStatusDetailsResponse{" +
				"rbmApprovedDate=" + rbmApprovedDate +
				", salesDivisionId='" + salesDivisionId + '\'' +
				", customerStateId='" + customerStateId + '\'' +
				", division='" + division + '\'' +
				", dbmId=" + dbmId +
				", tiQuantity='" + tiQuantity + '\'' +
				", dbmQuantity=" + dbmQuantity +
				", packingQuantity='" + packingQuantity + '\'' +
				", rbmApprovalStatus='" + rbmApprovalStatus + '\'' +
				", rbmName='" + rbmName + '\'' +
				", customerCode='" + customerCode + '\'' +
				", seasonEndDate='" + seasonEndDate + '\'' +
				", dbmName=" + dbmName +
				", territoryId='" + territoryId + '\'' +
				", saleOrganization='" + saleOrganization + '\'' +
				", cropCode='" + cropCode + '\'' +
				", requiredQuantityInKgs=" + requiredQuantityInKgs +
				", dbmApprovedTime=" + dbmApprovedTime +
				", deliveryLineItem='" + deliveryLineItem + '\'' +
				", salesRegionId='" + salesRegionId + '\'' +
				", distributionChannel='" + distributionChannel + '\'' +
				", tiId='" + tiId + '\'' +
				", quantityInKgsOrPackets='" + quantityInKgsOrPackets + '\'' +
				", indentTime='" + indentTime + '\'' +
				", dbmApprovedDate='" + dbmApprovedDate + '\'' +
				", rbmRemarks='" + rbmRemarks + '\'' +
				", indentOverallStatus='" + indentOverallStatus + '\'' +
				", cropName='" + cropName + '\'' +
				", territoryName='" + territoryName + '\'' +
				", varityCode='" + varityCode + '\'' +
				", baseUom='" + baseUom + '\'' +
				", dbmRemarks=" + dbmRemarks +
				", plant='" + plant + '\'' +
				", noOfPacketsRequired='" + noOfPacketsRequired + '\'' +
				", indentDate='" + indentDate + '\'' +
				", salesRegionName='" + salesRegionName + '\'' +
				", lineItemNo='" + lineItemNo + '\'' +
				", materialName='" + materialName + '\'' +
				", tiRemarks='" + tiRemarks + '\'' +
				", salesDivisionName='" + salesDivisionName + '\'' +
				", delivery='" + delivery + '\'' +
				", quantity='" + quantity + '\'' +
				", returnCutOffDate='" + returnCutOffDate + '\'' +
				", indentNo='" + indentNo + '\'' +
				", rbmApprovedTime='" + rbmApprovedTime + '\'' +
				", invoiceLineItem='" + invoiceLineItem + '\'' +
				", varityName='" + varityName + '\'' +
				", salesOffice='" + salesOffice + '\'' +
				", seasonCode='" + seasonCode + '\'' +
				", seasonStartingDate='" + seasonStartingDate + '\'' +
				", rbmQuantity='" + rbmQuantity + '\'' +
				", tiName='" + tiName + '\'' +
				", dbmApprovalStatus='" + dbmApprovalStatus + '\'' +
				", customerName='" + customerName + '\'' +
				", salesOrder='" + salesOrder + '\'' +
				", invoice='" + invoice + '\'' +
				", rbmId='" + rbmId + '\'' +
				", soLineItem='" + soLineItem + '\'' +
				", materialCode='" + materialCode + '\'' +
				", recID='" + recID + '\'' +
				'}';
	}
}