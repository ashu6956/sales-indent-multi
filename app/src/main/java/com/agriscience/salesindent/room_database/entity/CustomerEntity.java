package com.agriscience.salesindent.room_database.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "customer_entity")
public class CustomerEntity {

    @ColumnInfo(name = "sales_organization")
    private String salesOrganization;

    @ColumnInfo(name = "division")
    private String division;

    @ColumnInfo(name = "distribution_channel")
    private String distributionChannel;

    @ColumnInfo(name = "customer_name")
    private String customerName;


    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "customer_code")
    private String customerCode;

    @ColumnInfo(name = "territory_id")
    private String territoryId;

    @ColumnInfo(name = "sales_office")
    private String sales_office;

    @ColumnInfo(name = "status")
    private String status;

    @ColumnInfo(name = "state_id")
    private String stateId;

    public String getSales_office() {
        return sales_office;
    }

    public void setSales_office(String sales_office) {
        this.sales_office = sales_office;
    }

    public String getSalesOrganization() {
        return salesOrganization;
    }


    public void setSalesOrganization(String salesOrganization) {
        this.salesOrganization = salesOrganization;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDistributionChannel() {
        return distributionChannel;
    }

    public void setDistributionChannel(String distributionChannel) {
        this.distributionChannel = distributionChannel;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getTerritoryId() {
        return territoryId;
    }

    public void setTerritoryId(String territoryId) {
        this.territoryId = territoryId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "salesOrganization='" + salesOrganization + '\'' +
                ", division='" + division + '\'' +
                ", distributionChannel='" + distributionChannel + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", territoryId='" + territoryId + '\'' +
                ", status='" + status + '\'' +
                ", stateId='" + stateId + '\'' +
                '}';
    }
}
