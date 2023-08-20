package com.agriscience.salesindent.room_database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class STOIndentTmpEntity {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    transient
    private int id;


    @ColumnInfo
    @SerializedName("STO_indent_no")
    private String STO_indent_no;
    @ColumnInfo
    @SerializedName("indent_date")
    private String indent_date;
    @ColumnInfo
    @SerializedName("Indent_time")
    private String Indent_time;
    @ColumnInfo
    @SerializedName("Sending_plant")
    private String Sending_plant;
    @ColumnInfo
    @SerializedName("Receiving_plant")
    private String Receiving_plant;
    @PrimaryKey
    @ColumnInfo
    @NonNull
    @SerializedName("Line_no")
    private String Line_no;
    @ColumnInfo
    @SerializedName("Division")
    private String Division;
    @ColumnInfo
    @SerializedName("Crop_name")
    private String Crop_name;
    @ColumnInfo
    @SerializedName("Crop_code")
    private String Crop_code;
    @ColumnInfo
    @SerializedName("Variety_code")
    private String Variety_code;

    public String getVariety_code() {
        return Variety_code;
    }

    public void setVariety_code(String variety_code) {
        Variety_code = variety_code;
    }

    public String getVariety_name() {
        return Variety_name;
    }

    public void setVariety_name(String variety_name) {
        Variety_name = variety_name;
    }

    @ColumnInfo
    @SerializedName("Variety_name")
    private String Variety_name;
    @ColumnInfo
    @SerializedName("Material_code")
    private String Material_code;
    @ColumnInfo
    @SerializedName("Material_description")
    private String Material_description;
    @ColumnInfo
    @SerializedName("Final_status")
    private String Final_status;
    @ColumnInfo
    @SerializedName("Final_quantity")
    private String Final_quantity;
    @ColumnInfo
    @SerializedName("final_item_weight")
    private String final_item_weight;
    @ColumnInfo
    @SerializedName("final_no_of_pac")
    private String final_no_of_pac;
    @ColumnInfo
    @SerializedName("Req_date")
    private String Req_date;
    @ColumnInfo
    @SerializedName("Sales_region")
    private String Sales_region;
    @ColumnInfo
    @SerializedName("sales_region_name")
    private String sales_region_name;
    @ColumnInfo
    @SerializedName("RBM")
    private String RBM;
    @ColumnInfo
    @SerializedName("rbm_name")
    private String rbm_name;
    @ColumnInfo
    @SerializedName("rbm_qty")
    private String rbm_qty;
    @ColumnInfo
    @SerializedName("Rbm_item_weight")
    private String Rbm_item_weight;
    @ColumnInfo
    @SerializedName("Rbm_no_of_pac")
    private String Rbm_no_of_pac;
    @ColumnInfo
    @SerializedName("rbm_remarks")
    private String rbm_remarks;
    @ColumnInfo
    @SerializedName("sales_division")
    private String sales_division;
    @ColumnInfo
    @SerializedName("sales_division_name")
    private String sales_division_name;
    @ColumnInfo
    @SerializedName("dbm")
    private String dbm;
    @ColumnInfo
    @SerializedName("dbm_name")
    private String dbm_name;
    @ColumnInfo
    @SerializedName("dbm_remarks")
    private String dbm_remarks;
    @ColumnInfo
    @SerializedName("dbm_qty")
    private String dbm_qty;
    @ColumnInfo
    @SerializedName("dbm_item_weight")
    private String dbm_item_weight;
    @ColumnInfo
    @SerializedName("dbm_no_of_pac")
    private String dbm_no_of_pac;

    @SerializedName("packing_quantity")
    @ColumnInfo
    private String packingQuantity;

    @SerializedName("base_uom")
    @ColumnInfo
    private String baseUom;
    @ColumnInfo
    @SerializedName("dbm_approval_status")
    private String dbm_approval_status;
    @ColumnInfo
    @SerializedName("dbm_approval_date")
    private String dbm_approval_date;

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

    @ColumnInfo
    @SerializedName("dbm_approval_time")
    private String dbm_approval_time;

    public String getSTO_indent_no() {
        return STO_indent_no;
    }

    public void setSTO_indent_no(String STO_indent_no) {
        this.STO_indent_no = STO_indent_no;
    }

    public String getIndent_date() {
        return indent_date;
    }

    public void setIndent_date(String indent_date) {
        this.indent_date = indent_date;
    }

    public String getIndent_time() {
        return Indent_time;
    }

    public void setIndent_time(String indent_time) {
        Indent_time = indent_time;
    }

    public String getSending_plant() {
        return Sending_plant;
    }

    public void setSending_plant(String sending_plant) {
        Sending_plant = sending_plant;
    }

    public String getReceiving_plant() {
        return Receiving_plant;
    }

    public void setReceiving_plant(String receiving_plant) {
        Receiving_plant = receiving_plant;
    }

    public String getLine_no() {
        return Line_no;
    }

    public void setLine_no(String line_no) {
        Line_no = line_no;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        Division = division;
    }

    public String getCrop_name() {
        return Crop_name;
    }

    public void setCrop_name(String crop_name) {
        Crop_name = crop_name;
    }

    public String getCrop_code() {
        return Crop_code;
    }

    public void setCrop_code(String crop_code) {
        Crop_code = crop_code;
    }

    public String getMaterial_code() {
        return Material_code;
    }

    public void setMaterial_code(String material_code) {
        Material_code = material_code;
    }

    public String getMaterial_description() {
        return Material_description;
    }

    public void setMaterial_description(String material_description) {
        Material_description = material_description;
    }

    public String getFinal_status() {
        return Final_status;
    }

    public void setFinal_status(String final_status) {
        Final_status = final_status;
    }

    public String getFinal_quantity() {
        return Final_quantity;
    }

    public void setFinal_quantity(String final_quantity) {
        Final_quantity = final_quantity;
    }

    public String getFinal_item_weight() {
        return final_item_weight;
    }

    public void setFinal_item_weight(String final_item_weight) {
        this.final_item_weight = final_item_weight;
    }

    public String getFinal_no_of_pac() {
        return final_no_of_pac;
    }

    public void setFinal_no_of_pac(String final_no_of_pac) {
        this.final_no_of_pac = final_no_of_pac;
    }

    public String getReq_date() {
        return Req_date;
    }

    public void setReq_date(String req_date) {
        Req_date = req_date;
    }

    public String getSales_region() {
        return Sales_region;
    }

    public void setSales_region(String sales_region) {
        Sales_region = sales_region;
    }

    public String getSales_region_name() {
        return sales_region_name;
    }

    public void setSales_region_name(String sales_region_name) {
        this.sales_region_name = sales_region_name;
    }

    public String getRBM() {
        return RBM;
    }

    public void setRBM(String RBM) {
        this.RBM = RBM;
    }

    public String getRbm_name() {
        return rbm_name;
    }

    public void setRbm_name(String rbm_name) {
        this.rbm_name = rbm_name;
    }

    public String getRbm_qty() {
        return rbm_qty;
    }

    public void setRbm_qty(String rbm_qty) {
        this.rbm_qty = rbm_qty;
    }

    public String getRbm_item_weight() {
        return Rbm_item_weight;
    }

    public void setRbm_item_weight(String rbm_item_weight) {
        Rbm_item_weight = rbm_item_weight;
    }

    public String getRbm_no_of_pac() {
        return Rbm_no_of_pac;
    }

    public void setRbm_no_of_pac(String rbm_no_of_pac) {
        Rbm_no_of_pac = rbm_no_of_pac;
    }

    public String getRbm_remarks() {
        return rbm_remarks;
    }

    public void setRbm_remarks(String rbm_remarks) {
        this.rbm_remarks = rbm_remarks;
    }

    public String getSales_division() {
        return sales_division;
    }

    public void setSales_division(String sales_division) {
        this.sales_division = sales_division;
    }

    public String getSales_division_name() {
        return sales_division_name;
    }

    public void setSales_division_name(String sales_division_name) {
        this.sales_division_name = sales_division_name;
    }

    public String getDbm() {
        return dbm;
    }

    public void setDbm(String dbm) {
        this.dbm = dbm;
    }

    public String getDbm_name() {
        return dbm_name;
    }

    public void setDbm_name(String dbm_name) {
        this.dbm_name = dbm_name;
    }

    public String getDbm_remarks() {
        return dbm_remarks;
    }

    public void setDbm_remarks(String dbm_remarks) {
        this.dbm_remarks = dbm_remarks;
    }

    public String getDbm_qty() {
        return dbm_qty;
    }

    public void setDbm_qty(String dbm_qty) {
        this.dbm_qty = dbm_qty;
    }

    public String getDbm_item_weight() {
        return dbm_item_weight;
    }

    public void setDbm_item_weight(String dbm_item_weight) {
        this.dbm_item_weight = dbm_item_weight;
    }

    public String getDbm_no_of_pac() {
        return dbm_no_of_pac;
    }

    public void setDbm_no_of_pac(String dbm_no_of_pac) {
        this.dbm_no_of_pac = dbm_no_of_pac;
    }

    public String getDbm_approval_status() {
        return dbm_approval_status;
    }

    public void setDbm_approval_status(String dbm_approval_status) {
        this.dbm_approval_status = dbm_approval_status;
    }

    public String getDbm_approval_date() {
        return dbm_approval_date;
    }

    public void setDbm_approval_date(String dbm_approval_date) {
        this.dbm_approval_date = dbm_approval_date;
    }

    public String getDbm_approval_time() {
        return dbm_approval_time;
    }

    public void setDbm_approval_time(String dbm_approval_time) {
        this.dbm_approval_time = dbm_approval_time;
    }

    @Override
    public String toString() {
        return "STOIndentTmpEntity{" +
                "id=" + id +
                ", STO_indent_no='" + STO_indent_no + '\'' +
                ", indent_date='" + indent_date + '\'' +
                ", Indent_time='" + Indent_time + '\'' +
                ", Sending_plant='" + Sending_plant + '\'' +
                ", Receiving_plant='" + Receiving_plant + '\'' +
                ", Line_no='" + Line_no + '\'' +
                ", Division='" + Division + '\'' +
                ", Crop_name='" + Crop_name + '\'' +
                ", Crop_code='" + Crop_code + '\'' +
                ", Variety_code='" + Variety_code + '\'' +
                ", Variety_name='" + Variety_name + '\'' +
                ", Material_code='" + Material_code + '\'' +
                ", Material_description='" + Material_description + '\'' +
                ", Final_status='" + Final_status + '\'' +
                ", Final_quantity='" + Final_quantity + '\'' +
                ", final_item_weight='" + final_item_weight + '\'' +
                ", final_no_of_pac='" + final_no_of_pac + '\'' +
                ", Req_date='" + Req_date + '\'' +
                ", Sales_region='" + Sales_region + '\'' +
                ", sales_region_name='" + sales_region_name + '\'' +
                ", RBM='" + RBM + '\'' +
                ", rbm_name='" + rbm_name + '\'' +
                ", rbm_qty='" + rbm_qty + '\'' +
                ", Rbm_item_weight='" + Rbm_item_weight + '\'' +
                ", Rbm_no_of_pac='" + Rbm_no_of_pac + '\'' +
                ", rbm_remarks='" + rbm_remarks + '\'' +
                ", sales_division='" + sales_division + '\'' +
                ", sales_division_name='" + sales_division_name + '\'' +
                ", dbm='" + dbm + '\'' +
                ", dbm_name='" + dbm_name + '\'' +
                ", dbm_remarks='" + dbm_remarks + '\'' +
                ", dbm_qty='" + dbm_qty + '\'' +
                ", dbm_item_weight='" + dbm_item_weight + '\'' +
                ", dbm_no_of_pac='" + dbm_no_of_pac + '\'' +
                ", packingQuantity='" + packingQuantity + '\'' +
                ", baseUom='" + baseUom + '\'' +
                ", dbm_approval_status='" + dbm_approval_status + '\'' +
                ", dbm_approval_date='" + dbm_approval_date + '\'' +
                ", dbm_approval_time='" + dbm_approval_time + '\'' +
                '}';
    }
}


