package com.agriscience.salesindent.Retrofit;


import java.util.HashMap;
import java.util.Map;

import com.agriscience.salesindent.Retrofit.versionn;
import com.agriscience.salesindent.model.AmResponse;
import com.agriscience.salesindent.model.CustomerMasterResponse;
import com.agriscience.salesindent.model.IndentNoResponse;
import com.agriscience.salesindent.model.LoginResponse;
import com.agriscience.salesindent.model.MaterialSeasonResponse;
import com.agriscience.salesindent.model.PlantResponse;
import com.agriscience.salesindent.model.RbmResponse;
import com.agriscience.salesindent.model.STOIndentNoResponse;
import com.agriscience.salesindent.model.STOIndentResponse;
import com.agriscience.salesindent.model.STOMaterialResponse;
import com.agriscience.salesindent.model.STORbmResponse;
import com.agriscience.salesindent.model.SalesIndentStatusResponse;
import com.agriscience.salesindent.model.SuccessResponse;
import com.agriscience.salesindent.model.TmResponse;
import com.agriscience.salesindent.model.ZOrganogramResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("AppVersion.php") // specify the sub url for our base url
    Call<versionn> getversion(@Field("action")String action);

    @GET("get_Customer_Data.php")
    Call<CustomerMasterResponse>  getCustomerResponseDetails(@Query("Division") String division,
                                                             @Query("territory_id") String territoryId);


    @GET("get_Material_AND_Season_Data.php")
    Call<MaterialSeasonResponse> getMaterialAndSeasonResponseDetails(@Query("Division") String division,
                                                                     @Query("territory_id") String territoryId);

    @FormUrlEncoded
    @POST("verify_User_Details.php")
    Call<LoginResponse>  getLoginDetails(@FieldMap Map<String,String> params);

    @GET("get_Zorganogram_AllData.php")
    Call<ZOrganogramResponse> getZOrganogramDetails();

    @FormUrlEncoded
    @POST("create_SaleIndent.php")
    Call<SuccessResponse>  postSalesIndentRequest(@FieldMap HashMap<String,String> params);

    @GET("getTmAllIndentStatus.php")
    Call<SalesIndentStatusResponse> getAllSalesIndentStatus(@Query("t_incharge") String tIncharge);

    @GET("rbm/fetchAllTmUnderRBM.php")
    Call<TmResponse> getAllTmDetails(@Query("rbm_id") String rbmId);

    @GET("rbm/ISIndentDataFetchTMMALLIndent.php")
    Call<IndentNoResponse> getAllIndentNoDetails(@Query("t_incharge") String tIncharge);

    @GET("rbm/fetchDataIndentNoWise.php")
    Call<SalesIndentStatusResponse> getAllIndentDetailsByIndentNo(@Query("t_incharge") String tIncharge, @Query("indent_no") String indentNo);

    @FormUrlEncoded
    @POST("rbm/approveRejectRBM.php")
    Call<SuccessResponse>  postApproveRejectRequestByRBM(@FieldMap HashMap<String,String> params);

    @GET("rbm/getRbmAllIndentStatus.php")
    Call<SalesIndentStatusResponse> getAllRbmStatusDetails(@Query("rbm_id") String rbmId);


    @GET("dbm/fetchAllRBMUnderDBM.php")
    Call<RbmResponse> getAllDMDetails(@Query("dbm_id") String dbmId);

    @GET("dbm/ISIndentDataFetchDBMMALLIndent.php")
    Call<IndentNoResponse> getAllDBmIndentNoDetails(@Query("rbm_id") String rbmId);

    @GET("dbm/fetchDataIndentNoWise.php")
    Call<SalesIndentStatusResponse> getAllIndentDetailsByIndentNoInDBM(@Query("rbm_id") String rbmId, @Query("indent_no") String indentNo);

    @FormUrlEncoded
    @POST("dbm/approveRejectDBM.php")
    Call<SuccessResponse>  postApproveRejectRequestByDBM(@FieldMap HashMap<String,String> params);

    @GET("dbm/getDbmAllIndentStatus.php")
    Call<SalesIndentStatusResponse> getAllDbmStatusDetails(@Query("dbm_id") String dbmId);

    @GET("STO/getMaterialData.php")
    Call<STOMaterialResponse>  getMaterialResponse(@Query("Division") String division);

    @GET("STO/getAllPlants.php")
    Call<PlantResponse>  getAllPlantsResponse();

    @FormUrlEncoded
    @POST("STO/createSTO.php")
    Call<SuccessResponse>  postSTOIndentRequest(@FieldMap HashMap<String,String> params);


    @GET("STO/rbm/getRbmAllIndentStatus.php")
    Call<STOIndentResponse> getAllSTORbmStatusDetails(@Query("rbm_id") String rbmId);

    @GET("STO/dbm/getDbmAllIndentStatus.php")
    Call<STOIndentResponse> getAllSTODbmStatusDetails(@Query("dbm_id") String dbmId);

    @GET("STO/dbm/fetchAllRBMUnderDBM.php")
    Call<STORbmResponse> getAllSTORbmDetails(@Query("dbm_id") String dbmId);

    @GET("STO/dbm/getAllIndentUnderRBM.php")
    Call<STOIndentNoResponse> getAllSTOIndentDetails(@Query("rbm_id") String rbmId);


    @GET("STO/dbm/fetchDataIndentNoWise.php")
    Call<STOIndentResponse> getAllSTOIndentDetailsByIndentNoInDBM(@Query("rbm_id") String rbmId, @Query("STO_indent_no") String indentNo);

    @FormUrlEncoded
    @POST("STO/dbm/approveRejectDBM.php")
    Call<SuccessResponse>  postApproveRejectRequestBySTODBM(@FieldMap HashMap<String,String> params);



    // AM

    @GET("am/fetchAllTMUnderAM.php")
    Call<AmResponse> getAllAMDetails(@Query("am_id")  String amId);

    @GET("am/ISIndentDataFetchAMALLIndent.php")
    Call<IndentNoResponse> getAllAMIndentNoDetails(@Query("ti_id") String tId);

    @GET("am/fetchDataIndentNoWise.php")
    Call<SalesIndentStatusResponse> getAllAMIndentDetailsByIndentNo(@Query("ti_id") String tid, @Query("indent_no") String indentNo);

    @FormUrlEncoded
    @POST("am/approveRejectAM.php")
    Call<SuccessResponse>  postApproveRejectRequestByAM(@FieldMap HashMap<String,String> params);

    @GET("am/getAmAllIndentStatus.php")
    Call<SalesIndentStatusResponse> getAllAMStatusDetails(@Query("am_id") String amId);

}