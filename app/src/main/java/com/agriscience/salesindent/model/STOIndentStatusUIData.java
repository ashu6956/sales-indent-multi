package com.agriscience.salesindent.model;

public class STOIndentStatusUIData {

    private String indentNo;
    private String fromPlant;

    private String toPlant;
    private String reqDate;
    private String itemWeight;
    private String noOfPackets;
    private String qty;

    public String getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(String itemWeight) {
        this.itemWeight = itemWeight;
    }

    public String getNoOfPackets() {
        return noOfPackets;
    }

    public void setNoOfPackets(String noOfPackets) {
        this.noOfPackets = noOfPackets;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    private String recId;
    private String materialName;
    private String indentDate;
    private String itemRemarks;
    private String cancelRemarks;
    private boolean indentCheckBoxBool;
    private boolean approvalCheckBoxBool;
    private boolean rejectCheckBoxBool;

    private String baseUOM;
    private String packingQuantity;


    public String getFromPlant() {
        return fromPlant;
    }

    public void setFromPlant(String fromPlant) {
        this.fromPlant = fromPlant;
    }

    public String getToPlant() {
        return toPlant;
    }

    public void setToPlant(String toPlant) {
        this.toPlant = toPlant;
    }

    public String getReqDate() {
        return reqDate;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
    }


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

    public boolean isIndentCheckBoxBool() {
        return indentCheckBoxBool;
    }

    public void setIndentCheckBoxBool(boolean indentCheckBoxBool) {
        this.indentCheckBoxBool = indentCheckBoxBool;
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


}
