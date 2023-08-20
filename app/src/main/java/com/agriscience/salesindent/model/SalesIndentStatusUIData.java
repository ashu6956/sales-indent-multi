package com.agriscience.salesindent.model;

public class SalesIndentStatusUIData {

    private String indentNo;
    private String customerName;
    private String qtyInPkt;
    private String recId;
    private String materialName;
    private String indentDate;
    private String customerCode;
    private String qtyInBag;
    private String qtyInKg;
    private String itemRemarks;
    private String cancelRemarks;
    private boolean nameCheckBoxBool;
    private boolean approvalCheckBoxBool;
    private boolean rejectCheckBoxBool;

    private String baseUOM;
    private String packingQuantity;


    public String getBaseUOM() {
        return baseUOM;
    }

    public void setBaseUOM(String baseUOM) {
        this.baseUOM = baseUOM;
    }

    public String getIndentNo() {
        return indentNo;
    }

    public void setIndentNo(String indentNo) {
        this.indentNo = indentNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getQtyInPkt() {
        return qtyInPkt;
    }

    public void setQtyInPkt(String qtyInPkt) {
        this.qtyInPkt = qtyInPkt;
    }

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getIndentDate() {
        return indentDate;
    }

    public void setIndentDate(String indentDate) {
        this.indentDate = indentDate;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getQtyInBag() {
        return qtyInBag;
    }

    public void setQtyInBag(String qtyInBag) {
        this.qtyInBag = qtyInBag;
    }

    public String getQtyInKg() {
        return qtyInKg;
    }

    public void setQtyInKg(String qtyInKg) {
        this.qtyInKg = qtyInKg;
    }

    public String getItemRemarks() {
        return itemRemarks;
    }

    public void setItemRemarks(String itemRemarks) {
        this.itemRemarks = itemRemarks;
    }

    public String getCancelRemarks() {
        return cancelRemarks;
    }

    public void setCancelRemarks(String cancelRemarks) {
        this.cancelRemarks = cancelRemarks;
    }

    public boolean isNameCheckBoxBool() {
        return nameCheckBoxBool;
    }

    public void setNameCheckBoxBool(boolean nameCheckBoxBool) {
        this.nameCheckBoxBool = nameCheckBoxBool;
    }

    public boolean isApprovalCheckBoxBool() {
        return approvalCheckBoxBool;
    }

    public void setApprovalCheckBoxBool(boolean approvalCheckBoxBool) {
        this.approvalCheckBoxBool = approvalCheckBoxBool;
    }

    public boolean isRejectCheckBoxBool() {
        return rejectCheckBoxBool;
    }

    public void setRejectCheckBoxBool(boolean rejectCheckBoxBool) {
        this.rejectCheckBoxBool = rejectCheckBoxBool;
    }

    public String getPackingQuantity() {
        return packingQuantity;
    }

    public void setPackingQuantity(String packingQuantity) {
        this.packingQuantity = packingQuantity;
    }


    @Override
    public String toString() {
        return "SalesIndentStatusUIData{" +
                "indentNo='" + indentNo + '\'' +
                ", customerName='" + customerName + '\'' +
                ", qtyInPkt='" + qtyInPkt + '\'' +
                ", recId='" + recId + '\'' +
                ", materialName='" + materialName + '\'' +
                ", indentDate='" + indentDate + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", qtyInBag='" + qtyInBag + '\'' +
                ", qtyInKg='" + qtyInKg + '\'' +
                ", itemRemarks='" + itemRemarks + '\'' +
                ", cancelRemarks='" + cancelRemarks + '\'' +
                ", nameCheckBoxBool=" + nameCheckBoxBool +
                ", approvalCheckBoxBool=" + approvalCheckBoxBool +
                ", rejectCheckBoxBool=" + rejectCheckBoxBool +
                ", baseUOM='" + baseUOM + '\'' +
                ", packingQuantity='" + packingQuantity + '\'' +
                '}';
    }
}
