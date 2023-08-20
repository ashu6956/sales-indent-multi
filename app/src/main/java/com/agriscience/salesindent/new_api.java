package com.agriscience.salesindent;

public class new_api {

    // ---------------------------- Server Ip -------------------------------------------------

    private final static String ipconfig = "http://10.20.1.37:8080/hiveg/Sales_Indent_App/kanagaraj/";

    // ---------------------------- Local Ip -------------------------------------------------

//    private final static String ipconfig = "http://192.168.35.24/hiveg/Sales_Indent_App";
    public static String apk = ipconfig+"/Android/SalesIndent.apk";

    // ---------------------------- approved -------------------------------------------------

    public static String ISIndentDataFetchRBMMALLReport(String ProjectFolder , String POCodeGet){
        if (ProjectFolder != null) {
            return ipconfig + ProjectFolder + "/ISIndentDataFetchRBMMALLReport.php?RBMCode=" + POCodeGet;
        }else {
            return "null";
        }
    }


    // ---------------------------- dbmapproved -------------------------------------------------

    public static String ISIndentDataFetchDBMMALLReport(String ProjectFolder , String POCodeGet , String Acting, String Dcode){
        if (ProjectFolder != null) {
            return ipconfig + ProjectFolder + "/ISIndentDataFetchDBMMALLReport.php?DBMCode=" + POCodeGet + "&Acting="+Acting+"&Dcode="+Dcode;
        }else {
            return "null";
        }
    }


    // ---------------------------- DBMIndentApprovalProcess -------------------------------------------------

    public static String RegionFetchs(String projectFolder, String poCodeGet) {
        if (projectFolder != null) {
            return ipconfig + projectFolder + "/RegionFetchs.php?DBMCode=" + poCodeGet;
        }else {
            return "null";
        }
    }


    public static String ISIndenNoFetchDBMALL(String ProjectFolder , String POCodeGet ,String Acting ,String Dcode){
        if (ProjectFolder != null) {
            return ipconfig + ProjectFolder + "/ISIndenNoFetchDBMALL.php?DBMCode=" + POCodeGet+"&Acting="+Acting +"&Dcode="+Dcode;
        }else {
            return "null";
        }
    }

    public static String ISIndenNoFetchDBM(String ProjectFolder , String PoCodeSpinners ,String Acting ,String Dcode){
        if (ProjectFolder != null) {
            return ipconfig + ProjectFolder + "/ISIndenNoFetchDBM.php?RBMCode=" + PoCodeSpinners+"&Acting="+Acting+"&Dcode="+Dcode;
        }else {
            return "null";
        }
    }


    public static String ISIndentDataFetchDBMALL(String ProjectFolder , String POCodeGet,String Acting ,String Dcode){
        if (ProjectFolder != null) {
            return ipconfig + ProjectFolder + "/ISIndentDataFetchDBMALL.php?DBMCode=" + POCodeGet+"&Acting="+Acting+"&Dcode="+Dcode;
        }else {
            return "null";
        }
    }

    public static String ISIndentDataFetchDBM_RBMALL(String ProjectFolder , String PoCodeSpinners){
        if (ProjectFolder != null) {
            return ipconfig + ProjectFolder + "/ISIndentDataFetchDBM_RBMALL.php?RBMCode=" + PoCodeSpinners;
        }else {
            return "null";
        }
    }


    public static String ISIndentDataFetchDBM(String ProjectFolder , String IndentNos){
        if (ProjectFolder != null) {
            return ipconfig + ProjectFolder + "/ISIndentDataFetchDBM.php?IndentNo=" + IndentNos;
        }else {
            return "null";
        }
    }

    public static String ISUomMasterRBM(String projectFolder, String recIdCheck) {
        if (projectFolder != null) {
            return ipconfig + projectFolder + "/ISUomMasterRBM.php?RecID=" + recIdCheck;
        }else {
            return "null";
        }
    }

    public static String ISDataDBMUpdate(String projectFolder) {

        return ipconfig + projectFolder + "/ISDataDBMUpdate.php?";

    }


    // ---------------------------- DBMScreenActivity -------------------------------------------------

    public static String ISCustMaster(String projectFolder, String poCodeGet) {
        if (projectFolder != null) {
            return ipconfig + projectFolder + "/ISCustMaster.php?EmpCode=" + poCodeGet;
        }else {
            return "null";
        }
    }

    public static String ISSiteMaster(String projectFolder) {
        if (projectFolder != null) {
            return ipconfig + projectFolder + "/ISSiteMaster.php";
        }else {
            return "null";
        }
    }

    public static String ISWarehouseMaster(String projectFolder) {
        if (projectFolder != null) {
            return ipconfig + projectFolder + "/ISWarehouseMaster.php";
        }else {
            return "null";
        }
    }

    public static String ISItemMaster(String projectFolder) {
        if (projectFolder != null) {
            return ipconfig + projectFolder + "/ISItemMaster.php";
        }else {
            return "null";
        }
    }

    public static String ISCropMaster(String projectFolder) {
        if (projectFolder != null) {
            return ipconfig + projectFolder + "/ISCropMaster.php";
        }else {
            return "null";
        }
    }

    public static String NetworkStatusCheck() {

        return ipconfig + "/NetworkCheck/NetworkStatusCheck.php";
    }

    public static String ISIndentHeaderDataSynInsert(String projectFolder) {
        if (projectFolder != null) {
            return ipconfig + projectFolder + "/ISIndentHeaderDataSynInsert.php";
        }else {
            return "null";
        }
    }

    public static String ISIndentLineDataSynInsert(String projectFolder) {
        if (projectFolder != null) {
            return ipconfig + projectFolder + "/ISIndentLineDataSynInsert.php";
        }else {
            return "null";
        }
    }


    // ---------------------------- RBMIndentApprovalProcess -------------------------------------------------

    public static String TerritoryFetchs(String projectFolder, String poCodeGet) {
        if (projectFolder != null) {
            return ipconfig + projectFolder + "/TerritoryFetchs.php?RBMCode="+poCodeGet;
        }else {
            return "null";
        }
    }


    public static String ISIndenNoFetchRBMALL(String ProjectFolder , String POCodeGet,String Dcode){
        if (ProjectFolder != null) {
            return ipconfig + ProjectFolder + "/ISIndenNoFetchRBMALL.php?RBMCode=" + POCodeGet+"&Dcode="+Dcode;
        }else {
            return "null";
        }
    }

    public static String ISIndenNoFetchRBM(String ProjectFolder , String PoCodeSpinners,String Dcode){
        if (ProjectFolder != null) {
            return ipconfig + ProjectFolder + "/ISIndenNoFetchRBM.php?TMId=" + PoCodeSpinners+"&Dcode="+Dcode;
        }else {
            return "null";
        }
    }

    public static String ISIndentDataFetchRBMALL(String ProjectFolder , String POCodeGet){
        if (ProjectFolder != null) {
            return ipconfig + ProjectFolder + "/ISIndentDataFetchRBMALL.php?RBMCode=" + POCodeGet;
        }else {
            return "null";
        }
    }

    public static String ISIndentDataFetchRBM_TMALL(String ProjectFolder , String PoCodeSpinners){
        if (ProjectFolder != null) {
            return ipconfig + ProjectFolder + "/ISIndentDataFetchRBM_TMALL.php?TMCode=" + PoCodeSpinners;
        }else {
            return "null";
        }
    }

    public static String ISIndentDataFetchRBM(String ProjectFolder , String IndentNos){
        if (ProjectFolder != null) {
            return ipconfig + ProjectFolder + "/ISIndentDataFetchRBM.php?IndentNo=" + IndentNos;
        }else {
            return "null";
        }
    }


  // ---------------------------- tmapproved -------------------------------------------------

    public static String ISIndentDataFetchTMMALLReport(String ProjectFolder , String POCodeGet){
        if (ProjectFolder != null) {
            return ipconfig + ProjectFolder + "/ISIndentDataFetchTMMALLReport.php?TMCode=" + POCodeGet;
        }else {
            return "null";
        }
    }

    // ---------------------------- Login Activity -------------------------------------------------

    public static String ISLogin() {
        return ipconfig + "IndentSales/ISLogin.php";
    }

    public static String ISLogin(String ProjectFolder , String POCodeGet) {
        return ipconfig + ProjectFolder+ "/ISLogin.php?EmpCode="+POCodeGet;
    }

    public static String ISloginMasterFetchNew(String projectFolder, String poCodes) {
        if (projectFolder != null) {
            return ipconfig + projectFolder + "/ISloginMasterFetchNew.php?EmpCode=" + poCodes;
        }else {
            return "null";
        }
    }

    public static String ISUpdateDevice(String ProjectFolder) {
        return ipconfig + ProjectFolder+ "/ISUpdateDevice.php?";
    }

    public static String Version(String ProjectFolder) {
        return ipconfig + ProjectFolder+ "/Version.php?";
    }

    public static String ISDataRBMValidate(String projectFolder, String dcode) {
        if (projectFolder != null) {
            return ipconfig + projectFolder + "/ISDataRBMValidate.php?Dcode=" + dcode;
        }else {
            return "null";
        }
    }

    // ---------------------------- TM Screeen Activity -------------------------------------------------

    public static String ISCustomerMasterTM(String projectFolder, String poCodeGet) {
        if (projectFolder != null) {
            return ipconfig + projectFolder + "/ISCustomerMasterTM.php?TMCode=" + poCodeGet;
        }else {
            return "null";
        }
    }

    public static String ISSeedProcessPackingTable(String ProjectFolder) {
        return ipconfig + ProjectFolder+ "/ISSeedProcessPackingTable.php?";
    }

    public static String ISPriceMaster(String projectFolder, String poCodeGet) {
        if (projectFolder != null) {
            return ipconfig + projectFolder + "/ISPriceMaster.php?TMCode=" + poCodeGet;
        }else {
            return "null";
        }
    }
}

