package com.agriscience.salesindent;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class AppSharedPreferences {

    private SharedPreferences pref;
    private Editor editor;
    private Context _context;
    private static final String PREF_NAME = "Session";
    private static final String DCode = "DCode";
    private static final String Site = "site";
    private static final String WareHouse = "warehouse";
    private static final String T_INCHARGE = "t_incharge";
    private static final String SiteTM = "siteTM";
    private static final String WareHouseTM = "warehouseTM";
    private static final String SiteRBM = "siteRBM";
    private static final String WareHouseRBM = "warehouseRBM";
    private static final String NotifyCount = "notify_count";
    private static final String NotifyData = "notify_data";
    private static final String zmLogin = "ZMLogin";


    public static final String USER_ID = "POCodeTransfer";
    public static final String USER_NAME = "PONameTransfer";
    private static final String Tm_name = "TerritoryNameTransfer";
    private static final String Post_code = "PostCodeTransfer";
    private static final String Site_ID = "SiteTransfer";
    private static final String Division_code = "DivisionTransfer";
    private static final String Action_Code = "Acting";
    private static final String D_Code = "DCode";

    private static final String TERRITORY_ID = "territory_id";
    private static final String DIVISION = "DIVISION";
    private static final String LOGIN_ROLE = "login_role";

    private static final String IS_TM = "IsTm";
    private static final String IS_AM = "IsAm";
    private static final String IS_RBM = "IsRbm";
    private static final String IS_DBM = "IsDbm";


    private static final String latestVersion = "latestversion";


    // Constructor
    @SuppressLint("CommitPrefEdits")
    public AppSharedPreferences(Context context) {
        this._context = context;
        int PRIVATE_MODE = 0;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void put_dcode(String dcode) {
        editor.putString(DCode, dcode);
        editor.commit();
    }

    public void put_InCharge(String dcode) {
        editor.putString(DCode, dcode);
        editor.commit();
    }

    public void put_ZM(String dd) {
        editor.putString(zmLogin, dd);
        editor.commit();
    }

    ////----------------------------session of DM01----------------------------------------------

    public void putUserId(String dd) {
        editor.putString(USER_ID, dd);
        editor.commit();
    }

    public void putName(String dd) {
        editor.putString(USER_NAME, dd);
        editor.commit();
    }

    public void Tm_name(String dd) {
        editor.putString(Tm_name, dd);
        editor.commit();
    }

    public void Post_code(String dd) {
        editor.putString(Post_code, dd);
        editor.commit();
    }

    public void Site_ID(String dd) {
        editor.putString(Site_ID, dd);
        editor.commit();
    }

    public void Division_code(String dd) {
        editor.putString(Division_code, dd);
        editor.commit();
    }

    public void putDivision(String division) {
        editor.putString(DIVISION, division);
        editor.commit();
    }


    public void Action_Code(String dd) {
        editor.putString(Action_Code, dd);
        editor.commit();
    }

    public void D_Code(String dd) {
        editor.putString(D_Code, dd);
        editor.commit();
    }

    public void putTerritoryId(String territoryId) {
        editor.putString(TERRITORY_ID, territoryId);
        editor.commit();
    }

    public void putLoginRole(String role) {
        editor.putString(LOGIN_ROLE, role);
        editor.commit();
    }

    public void putIsTM(boolean isTM) {
        editor.putBoolean(IS_TM, isTM);
        editor.commit();
    }

    public void putIsAM(boolean isAM) {
        editor.putBoolean(IS_AM, isAM);
        editor.commit();
    }

    public void putIsRbM(boolean isRbm) {
        editor.putBoolean(IS_RBM, isRbm);
        editor.commit();
    }

    public void putIsDbM(boolean isDbm) {
        editor.putBoolean(IS_DBM, isDbm);
        editor.commit();
    }


    /////////////////////////////////////GET Values of DM01////////////////////////////////////////
    public String getUserId() {
        return pref.getString(USER_ID, null);
    }

    public boolean getIsTM() {
        return pref.getBoolean(IS_TM, false);
    }

    public boolean getIsAM() {
        return pref.getBoolean(IS_AM, false);
    }

    public boolean getIsRbm() {
        return pref.getBoolean(IS_RBM, false);
    }

    public boolean getIsDbm() {
        return pref.getBoolean(IS_DBM, false);
    }


    public String getLoginRole() {
        return pref.getString(LOGIN_ROLE, null);
    }

    public String getTerritoryId() {
        return pref.getString(TERRITORY_ID, "null");
    }

    public String getDivision() {
        return pref.getString(DIVISION, "null");
    }

    public String getUserName() {
        return pref.getString(USER_NAME, "null");
    }

    public String get_Tm_name() {
        return pref.getString(Tm_name, "null");
    }

    public String get_Post_code() {
        return pref.getString(Post_code, "null");
    }

    public String get_Site_ID() {
        return pref.getString(Site_ID, "null");
    }

    public String get_Division_code() {
        return pref.getString(Division_code, "null");
    }

    public String get_Action_Code() {
        return pref.getString(Action_Code, "null");
    }

    public String get_D_Code() {
        return pref.getString(D_Code, "null");
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////

    ////-----------------------------------------------------------------------------------------
    public String get_zm() {
        return pref.getString(zmLogin, "null");
    }


    public String get_dcode() {
        return pref.getString(DCode, "null");
    }

//    public void put_site(String site){
//        editor.putString(Site, site);
//        editor.commit();
//    }
//
//    public String get_site(){
//        return pref.getString(Site,"null");
//    }
//
//    public void put_warehouse(String warehouse){
//        editor.putString(WareHouse, warehouse);
//        editor.commit();
//    }
//
//    public String get_warehouse(){
//        return pref.getString(WareHouse,"null");
//    }

    public void put_siteTM(String site) {
        editor.putString(SiteTM, site);
        editor.commit();
    }

    public String get_siteTM() {
        return pref.getString(SiteTM, "null");
    }

    public void put_warehouseTM(String warehouse) {
        editor.putString(WareHouseTM, warehouse);
        editor.commit();
    }

    public String get_warehouseTM() {
        return pref.getString(WareHouseTM, "null");
    }

    public void put_siteRBM(String site) {
        editor.putString(SiteRBM, site);
        editor.commit();
    }

    public String get_siteRBM() {
        return pref.getString(SiteRBM, "null");
    }

    public void put_warehouseRBM(String warehouse) {
        editor.putString(WareHouseRBM, warehouse);
        editor.commit();
    }

    public String get_warehouseRBM() {
        return pref.getString(WareHouseRBM, "null");
    }

    public void put_notify_data(String notify) {
        editor.putString(NotifyData, notify);
        editor.commit();
    }

    public String get_notify_data() {
        return pref.getString(NotifyData, "null");
    }


    public void put_notify_count(int notify) {
        editor.putInt(NotifyCount, notify);
        editor.commit();
    }

    public int get_notify_count() {
        return pref.getInt(NotifyCount, 0);
    }

    public void clear() {
        editor.clear();
    }

    public void save_version(int latestAppVersion) {
        editor.putInt(latestVersion, latestAppVersion);
        editor.commit();
    }

    public int get_version() {
        return pref.getInt(latestVersion, 8);
    }
}