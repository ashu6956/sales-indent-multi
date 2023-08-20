package com.agriscience.salesindent.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MaterialSeasonResponse {

	@SerializedName("Acsen_MaterialMaster_Res")
	private List<MaterialMasterDetailResponse> acsenMaterialMasterRes;

	@SerializedName("Acsen_SeasonMaster_Res")
	private List<SeasonMasterDetailsResponse> acsenSeasonMasterRes;

	public void setAcsenMaterialMasterRes(List<MaterialMasterDetailResponse> acsenMaterialMasterRes){
		this.acsenMaterialMasterRes = acsenMaterialMasterRes;
	}

	public List<MaterialMasterDetailResponse> getAcsenMaterialMasterRes(){
		return acsenMaterialMasterRes;
	}

	public void setAcsenSeasonMasterRes(List<SeasonMasterDetailsResponse> acsenSeasonMasterRes){
		this.acsenSeasonMasterRes = acsenSeasonMasterRes;
	}

	public List<SeasonMasterDetailsResponse> getAcsenSeasonMasterRes(){
		return acsenSeasonMasterRes;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"acsen_MaterialMaster_Res = '" + acsenMaterialMasterRes + '\'' + 
			",acsen_SeasonMaster_Res = '" + acsenSeasonMasterRes + '\'' + 
			"}";
		}
}