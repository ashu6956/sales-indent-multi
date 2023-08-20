package com.agriscience.salesindent.room_database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class SalesIndentDetailsTmpEntity {
    @ColumnInfo(name = "indent_no")
    @SerializedName("indent_no")
    private String IndentNo;

    @ColumnInfo(name = "SlNo")
    private String SlNo;

    @ColumnInfo(name = "indent_date")
    @SerializedName("indent_date")
    private String IndentDate;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "indent_time")
    @SerializedName("indent_time")
    private String IndentTime;


    @ColumnInfo(name = "sale_organization")
    @SerializedName("sale_organization")
    private String saleOrganization;

    @ColumnInfo(name = "distribution_channel")
    @SerializedName("distribution_channel")
    private String distributionChannel;

    @ColumnInfo(name = "division")
    @SerializedName("division")
    private String division;

    @ColumnInfo(name = "sales_office")
    @SerializedName("sales_office")
    private String SalesOffice;

    @ColumnInfo(name = "customer_code")
    @SerializedName("customer_code")
    private String customerCode;

    @ColumnInfo(name = "customer_name")
    @SerializedName("customer_name")
    private String customerName;

    @ColumnInfo(name = "customer_state_id")
    @SerializedName("customer_state_id")
    private String customerStateId;

    @ColumnInfo(name = "crop_code")
    @SerializedName("crop_code")
    private String cropCode;

    @ColumnInfo(name = "crop_name")
    @SerializedName("crop_name")
    private String cropName;

    @ColumnInfo(name = "season_code")
    @SerializedName("season_code")
    private String seasonCode;

    @ColumnInfo(name = "season_starting_date")
    @SerializedName("season_starting_date")
    private String seasonStartingDate;

    @ColumnInfo(name = "season_end_date")
    @SerializedName("season_end_date")
    private String seasonEndDate;

    @ColumnInfo(name = "return_cut-off_date")
    @SerializedName("return_cut-off_date")
    private String returnCutOffDate;

    @ColumnInfo(name = "variety_code")
    @SerializedName("variety_code")
    private String varietyCode;

    @ColumnInfo(name = "variety_name")
    @SerializedName("variety_name")
    private String varietyName;

    @ColumnInfo(name = "line_item_no")
    @SerializedName("line_item_no")
    private String lineItemNo;

    @ColumnInfo(name = "material_code")
    @SerializedName("material_code")
    private String materialCode;

    @ColumnInfo(name = "material_name")
    @SerializedName("material_name")
    private String materialName;

    @ColumnInfo(name = "plant")
    @SerializedName("plant")
    private String plant;

    @ColumnInfo(name = "base_uom")
    @SerializedName("base_uom")
    private String baseUom;

    @ColumnInfo(name = "packing_quantity")
    @SerializedName("packing_quantity")
    private String packingQuantity;

    @ColumnInfo(name = "quantity_in_kgs_or_packets")
    @SerializedName("quantity_in_kgs_or_packets")
    private String quantityInKgsOrPackets;

    @ColumnInfo(name = "required_quantity_in_kgs")
    @SerializedName("required_quantity_in_kgs")
    private String requiredQuantityInKgs;

    @ColumnInfo(name = "no_of_packets_required")
    @SerializedName("no_of_packets_required")
    private String noOfPacketsRequired;

    @ColumnInfo(name = "indent_overall_status")
    @SerializedName("indent_overall_status")
    private String indentOverAllStatus;

    @ColumnInfo(name = "territory_id")
    @SerializedName("territory_id")
    private String territoryId;


    @ColumnInfo(name = "territory_name")
    @SerializedName("territory_name")
    private String territoryName;

    @ColumnInfo(name = "ti_id")
    @SerializedName("ti_id")
    private String tiId;

    @ColumnInfo(name = "ti_name")
    @SerializedName("ti_name")
    private String tiName;

    @ColumnInfo(name = "ti_quantity")
    @SerializedName("ti_quantity")
    private String tiQuantity;

    @ColumnInfo(name = "ti_remarks")
    @SerializedName("ti_remarks")
    private String tiRemarks;

    @ColumnInfo(name = "sales_region_id")
    @SerializedName("sales_region_id")
    private String salesRegionId;


    @ColumnInfo(name = "sales_region_name")
    @SerializedName("sales_region_name")
    private String salesRegionName;


    @ColumnInfo(name = "rbm_id")
    @SerializedName("rbm_id")
    private String rbmId;


    @ColumnInfo(name = "rbm_name")
    @SerializedName("rbm_name")
    private String rbmName;


    @ColumnInfo(name = "rbm_quantity")
    @SerializedName("rbm_quantity")
    private String rbmQuantity;


    @ColumnInfo(name = "rbm_approval_status")
    @SerializedName("rbm_approval_status")
    private String rbmApprovalStatus;


    @ColumnInfo(name = "rbm_approved_date")
    @SerializedName("rbm_approved_date")
    private String rbmApprovedDate;


    @ColumnInfo(name = "rbm_approved_time")
    @SerializedName("rbm_approved_time")
    private String rbmApprovedTime;

    @ColumnInfo(name = "rbm_remarks")
    @SerializedName("rbm_remarks")
    private String rbmRemarks;

    @ColumnInfo(name = "sales_division_id")
    @SerializedName("sales_division_id")
    private String salesDivisionId;

    @ColumnInfo(name = "sales_division_name")
    @SerializedName("sales_division_name")
    private String salesDivisionName;


    public String getIndentNo() {
        return IndentNo;
    }

    public void setIndentNo(String indentNo) {
        IndentNo = indentNo;
    }

    public String getSlNo() {
        return SlNo;
    }

    public void setSlNo(String slNo) {
        SlNo = slNo;
    }

    public String getIndentDate() {
        return IndentDate;
    }

    public void setIndentDate(String indentDate) {
        IndentDate = indentDate;
    }

    public String getIndentTime() {
        return IndentTime;
    }

    public void setIndentTime(String indentTime) {
        IndentTime = indentTime;
    }

    public String getSaleOrganization() {
        return saleOrganization;
    }

    public void setSaleOrganization(String saleOrganization) {
        this.saleOrganization = saleOrganization;
    }

    public String getDistributionChannel() {
        return distributionChannel;
    }

    public void setDistributionChannel(String distributionChannel) {
        this.distributionChannel = distributionChannel;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getSalesOffice() {
        return SalesOffice;
    }

    public void setSalesOffice(String salesOffice) {
        SalesOffice = salesOffice;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerStateId() {
        return customerStateId;
    }

    public void setCustomerStateId(String customerStateId) {
        this.customerStateId = customerStateId;
    }

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

    public String getSeasonCode() {
        return seasonCode;
    }

    public void setSeasonCode(String seasonCode) {
        this.seasonCode = seasonCode;
    }

    public String getSeasonStartingDate() {
        return seasonStartingDate;
    }

    public void setSeasonStartingDate(String seasonStartingDate) {
        this.seasonStartingDate = seasonStartingDate;
    }

    public String getSeasonEndDate() {
        return seasonEndDate;
    }

    public void setSeasonEndDate(String seasonEndDate) {
        this.seasonEndDate = seasonEndDate;
    }

    public String getReturnCutOffDate() {
        return returnCutOffDate;
    }

    public void setReturnCutOffDate(String returnCutOffDate) {
        this.returnCutOffDate = returnCutOffDate;
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

    public String getLineItemNo() {
        return lineItemNo;
    }

    public void setLineItemNo(String lineItemNo) {
        this.lineItemNo = lineItemNo;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getBaseUom() {
        return baseUom;
    }

    public void setBaseUom(String baseUom) {
        this.baseUom = baseUom;
    }

    public String getPackingQuantity() {
        return packingQuantity;
    }

    public void setPackingQuantity(String packingQuantity) {
        this.packingQuantity = packingQuantity;
    }

    public String getQuantityInKgsOrPackets() {
        return quantityInKgsOrPackets;
    }

    public void setQuantityInKgsOrPackets(String quantityInKgsOrPackets) {
        this.quantityInKgsOrPackets = quantityInKgsOrPackets;
    }

    public String getRequiredQuantityInKgs() {
        return requiredQuantityInKgs;
    }

    public void setRequiredQuantityInKgs(String requiredQuantityInKgs) {
        this.requiredQuantityInKgs = requiredQuantityInKgs;
    }

    public String getNoOfPacketsRequired() {
        return noOfPacketsRequired;
    }

    public void setNoOfPacketsRequired(String noOfPacketsRequired) {
        this.noOfPacketsRequired = noOfPacketsRequired;
    }

    public String getIndentOverAllStatus() {
        return indentOverAllStatus;
    }

    public void setIndentOverAllStatus(String indentOverAllStatus) {
        this.indentOverAllStatus = indentOverAllStatus;
    }

    public String getTerritoryId() {
        return territoryId;
    }

    public void setTerritoryId(String territoryId) {
        this.territoryId = territoryId;
    }

    public String getTerritoryName() {
        return territoryName;
    }

    public void setTerritoryName(String territoryName) {
        this.territoryName = territoryName;
    }

    public String getTiId() {
        return tiId;
    }

    public void setTiId(String tiId) {
        this.tiId = tiId;
    }

    public String getTiName() {
        return tiName;
    }

    public void setTiName(String tiName) {
        this.tiName = tiName;
    }

    public String getTiQuantity() {
        return tiQuantity;
    }

    public void setTiQuantity(String tiQuantity) {
        this.tiQuantity = tiQuantity;
    }

    public String getTiRemarks() {
        return tiRemarks;
    }

    public void setTiRemarks(String tiRemarks) {
        this.tiRemarks = tiRemarks;
    }

    public String getSalesRegionId() {
        return salesRegionId;
    }

    public void setSalesRegionId(String salesRegionId) {
        this.salesRegionId = salesRegionId;
    }

    public String getSalesRegionName() {
        return salesRegionName;
    }

    public void setSalesRegionName(String salesRegionName) {
        this.salesRegionName = salesRegionName;
    }

    public String getRbmId() {
        return rbmId;
    }

    public void setRbmId(String rbmId) {
        this.rbmId = rbmId;
    }

    public String getRbmName() {
        return rbmName;
    }

    public void setRbmName(String rbmName) {
        this.rbmName = rbmName;
    }

    public String getRbmQuantity() {
        return rbmQuantity;
    }

    public void setRbmQuantity(String rbmQuantity) {
        this.rbmQuantity = rbmQuantity;
    }

    public String getRbmApprovalStatus() {
        return rbmApprovalStatus;
    }

    public void setRbmApprovalStatus(String rbmApprovalStatus) {
        this.rbmApprovalStatus = rbmApprovalStatus;
    }

    public String getRbmApprovedDate() {
        return rbmApprovedDate;
    }

    public void setRbmApprovedDate(String rbmApprovedDate) {
        this.rbmApprovedDate = rbmApprovedDate;
    }

    public String getRbmApprovedTime() {
        return rbmApprovedTime;
    }

    public void setRbmApprovedTime(String rbmApprovedTime) {
        this.rbmApprovedTime = rbmApprovedTime;
    }

    public String getRbmRemarks() {
        return rbmRemarks;
    }

    public void setRbmRemarks(String rbmRemarks) {
        this.rbmRemarks = rbmRemarks;
    }

    public String getSalesDivisionId() {
        return salesDivisionId;
    }

    public void setSalesDivisionId(String salesDivisionId) {
        this.salesDivisionId = salesDivisionId;
    }

    public String getSalesDivisionName() {
        return salesDivisionName;
    }

    public void setSalesDivisionName(String salesDivisionName) {
        this.salesDivisionName = salesDivisionName;
    }

    @Override
    public String toString() {
        return "SalesIndentDetailsTmpEntity{" +
                ", IndentNo='" + IndentNo + '\'' +
                ", SlNo='" + SlNo + '\'' +
                ", IndentDate='" + IndentDate + '\'' +
                ", IndentTime='" + IndentTime + '\'' +
                ", saleOrganization='" + saleOrganization + '\'' +
                ", distributionChannel='" + distributionChannel + '\'' +
                ", division='" + division + '\'' +
                ", SalesOffice='" + SalesOffice + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerStateId='" + customerStateId + '\'' +
                ", cropCode='" + cropCode + '\'' +
                ", cropName='" + cropName + '\'' +
                ", seasonCode='" + seasonCode + '\'' +
                ", seasonStartingDate='" + seasonStartingDate + '\'' +
                ", seasonEndDate='" + seasonEndDate + '\'' +
                ", returnCutOffDate='" + returnCutOffDate + '\'' +
                ", varietyCode='" + varietyCode + '\'' +
                ", varietyName='" + varietyName + '\'' +
                ", lineItemNo='" + lineItemNo + '\'' +
                ", materialCode='" + materialCode + '\'' +
                ", materialName='" + materialName + '\'' +
                ", plant='" + plant + '\'' +
                ", baseUom='" + baseUom + '\'' +
                ", packingQuantity='" + packingQuantity + '\'' +
                ", quantityInKgsOrPackets='" + quantityInKgsOrPackets + '\'' +
                ", requiredQuantityInKgs='" + requiredQuantityInKgs + '\'' +
                ", noOfPacketsRequired='" + noOfPacketsRequired + '\'' +
                ", indentOverAllStatus='" + indentOverAllStatus + '\'' +
                ", territoryId='" + territoryId + '\'' +
                ", territoryName='" + territoryName + '\'' +
                ", tiId='" + tiId + '\'' +
                ", tiName='" + tiName + '\'' +
                ", tiQuantity='" + tiQuantity + '\'' +
                ", tiRemarks='" + tiRemarks + '\'' +
                ", salesRegionId='" + salesRegionId + '\'' +
                ", salesRegionName='" + salesRegionName + '\'' +
                ", rbmId='" + rbmId + '\'' +
                ", rbmName='" + rbmName + '\'' +
                ", rbmQuantity='" + rbmQuantity + '\'' +
                ", rbmApprovalStatus='" + rbmApprovalStatus + '\'' +
                ", rbmApprovedDate='" + rbmApprovedDate + '\'' +
                ", rbmApprovedTime='" + rbmApprovedTime + '\'' +
                ", rbmRemarks='" + rbmRemarks + '\'' +
                ", salesDivisionId='" + salesDivisionId + '\'' +
                ", salesDivisionName='" + salesDivisionName + '\'' +
                '}';
    }
}
