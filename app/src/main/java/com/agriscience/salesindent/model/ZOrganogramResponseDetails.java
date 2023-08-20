package com.agriscience.salesindent.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class ZOrganogramResponseDetails {
	@SerializedName("sales_division_name")
	@ColumnInfo
	private String salesDivisionName;

	@SerializedName("territory_name")
	@ColumnInfo
	private String territoryName;

	@SerializedName("data_updated_in_mobile")
	@ColumnInfo
	private String dataUpdatedInMobile;

	@SerializedName("t_incharge")
	@ColumnInfo
	private String inChargeT;

	@SerializedName("active")
	@ColumnInfo
	private String active;

	@SerializedName("dbm")
	@ColumnInfo
	private String dbm;

	@SerializedName("data_updated_in_sap")
    @ColumnInfo
   	private String dataUpdatedInSap;

	@SerializedName("division")
	@ColumnInfo
	private String division;

	@SerializedName("sales_division")
	@ColumnInfo
	private String salesDivision;

	@SerializedName("plant")
	@ColumnInfo
	private String plant;

	@SerializedName("ti_name")
	@ColumnInfo
	private String tiName;

	@SerializedName("region_name")
	@ColumnInfo
	private String regionName;

	@SerializedName("rbm_name")
	@ColumnInfo
	private String rbmName;

	@SerializedName("region")
	@ColumnInfo
	private String region;

	@SerializedName("rbm")
	@ColumnInfo
	private String rbm;

	@SerializedName("dbm_name")
	@ColumnInfo
	private String dbmName;

	public String getPlant_name() {
		return Plant_name;
	}

	public void setPlant_name(String plant_name) {
		Plant_name = plant_name;
	}

	@SerializedName("Plant_name")
	@ColumnInfo
	private String Plant_name;
	@PrimaryKey
	@NonNull
	@SerializedName("territory_id")
	@ColumnInfo
	private String territoryId;

	@SerializedName("status")
	@ColumnInfo
	private String status;

	@SerializedName("Area_Manager")
	@ColumnInfo
	private String areaManager;

	@SerializedName("Area_ManagerName")
	@ColumnInfo
	private String areaManagerName;

	public String getSalesDivisionName() {
		return salesDivisionName;
	}

	public void setSalesDivisionName(String salesDivisionName) {
		this.salesDivisionName = salesDivisionName;
	}

	public String getTerritoryName() {
		return territoryName;
	}

	public void setTerritoryName(String territoryName) {
		this.territoryName = territoryName;
	}

	public String getDataUpdatedInMobile() {
		return dataUpdatedInMobile;
	}

	public void setDataUpdatedInMobile(String dataUpdatedInMobile) {
		this.dataUpdatedInMobile = dataUpdatedInMobile;
	}


	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getDbm() {
		return dbm;
	}

	public void setDbm(String dbm) {
		this.dbm = dbm;
	}

	public String getDataUpdatedInSap() {
		return dataUpdatedInSap;
	}

	public void setDataUpdatedInSap(String dataUpdatedInSap) {
		this.dataUpdatedInSap = dataUpdatedInSap;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getSalesDivision() {
		return salesDivision;
	}

	public void setSalesDivision(String salesDivision) {
		this.salesDivision = salesDivision;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getTiName() {
		return tiName;
	}

	public void setTiName(String tiName) {
		this.tiName = tiName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getRbmName() {
		return rbmName;
	}

	public void setRbmName(String rbmName) {
		this.rbmName = rbmName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRbm() {
		return rbm;
	}

	public void setRbm(String rbm) {
		this.rbm = rbm;
	}

	public String getDbmName() {
		return dbmName;
	}

	public void setDbmName(String dbmName) {
		this.dbmName = dbmName;
	}

	public String getTerritoryId() {
		return territoryId;
	}

	public void setTerritoryId(String territoryId) {
		this.territoryId = territoryId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInChargeT() {
		return inChargeT;
	}

	public void setInChargeT(String inChargeT) {
		this.inChargeT = inChargeT;
	}


	public String getAreaManager() {
		return areaManager;
	}

	public void setAreaManager(String areaManager) {
		this.areaManager = areaManager;
	}

	public String getAreaManagerName() {
		return areaManagerName;
	}

	public void setAreaManagerName(String areaManagerName) {
		this.areaManagerName = areaManagerName;
	}

	@Override
	public String toString() {
		return "ZOrganogramResponseDetails{" +
				"salesDivisionName='" + salesDivisionName + '\'' +
				", territoryName='" + territoryName + '\'' +
				", dataUpdatedInMobile='" + dataUpdatedInMobile + '\'' +
				", inChargeT='" + inChargeT + '\'' +
				", active='" + active + '\'' +
				", dbm='" + dbm + '\'' +
				", dataUpdatedInSap='" + dataUpdatedInSap + '\'' +
				", division='" + division + '\'' +
				", salesDivision='" + salesDivision + '\'' +
				", plant='" + plant + '\'' +
				", tiName='" + tiName + '\'' +
				", regionName='" + regionName + '\'' +
				", rbmName='" + rbmName + '\'' +
				", region='" + region + '\'' +
				", rbm='" + rbm + '\'' +
				", dbmName='" + dbmName + '\'' +
				", territoryId='" + territoryId + '\'' +
				", status='" + status + '\'' +
				", areaManager='" + areaManager + '\'' +
				", areaManagerName='" + areaManagerName + '\'' +
				'}';
	}
}