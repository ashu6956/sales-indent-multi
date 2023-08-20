package com.agriscience.salesindent.model;

import com.google.gson.annotations.SerializedName;

public class CustomerMasterDetailsResponse {

	@SerializedName("sales_organization")
	private String salesOrganization;

	@SerializedName("division")
	private String division;

	@SerializedName("distribution_channel")
	private String distributionChannel;

	@SerializedName("customer_name")
	private String customerName;

	@SerializedName("state_id")
	private String stateId;

	@SerializedName("customer_code")
	private String customerCode;

	public String getSales_office() {
		return sales_office;
	}

	public void setSales_office(String sales_office) {
		this.sales_office = sales_office;
	}

	@SerializedName("sales_office")
	private String sales_office;

	@SerializedName("territory_id")
	private String territoryId;

	@SerializedName("status")
	private String status;

	public void setSalesOrganization(String salesOrganization){
		this.salesOrganization = salesOrganization;
	}

	public String getSalesOrganization(){
		return salesOrganization;
	}

	public void setDivision(String division){
		this.division = division;
	}

	public String getDivision(){
		return division;
	}

	public void setDistributionChannel(String distributionChannel){
		this.distributionChannel = distributionChannel;
	}

	public String getDistributionChannel(){
		return distributionChannel;
	}

	public void setCustomerName(String customerName){
		this.customerName = customerName;
	}

	public String getCustomerName(){
		return customerName;
	}

	public void setCustomerCode(String customerCode){
		this.customerCode = customerCode;
	}

	public String getCustomerCode(){
		return customerCode;
	}

	public void setTerritoryId(String territoryId){
		this.territoryId = territoryId;
	}

	public String getTerritoryId(){
		return territoryId;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "CustomerMasterDetailsResponse{" +
				"salesOrganization='" + salesOrganization + '\'' +
				", division='" + division + '\'' +
				", distributionChannel='" + distributionChannel + '\'' +
				", customerName='" + customerName + '\'' +
				", stateId='" + stateId + '\'' +
				", customerCode='" + customerCode + '\'' +
				", territoryId='" + territoryId + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}