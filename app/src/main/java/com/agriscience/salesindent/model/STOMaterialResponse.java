package com.agriscience.salesindent.model;

import com.agriscience.salesindent.model.STOMaterialDetailsResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class STOMaterialResponse{

	@SerializedName("Acsen_MaterialMaster_Res")
	private List<STOMaterialDetailsResponse> acsenMaterialMasterRes;

	public void setAcsenMaterialMasterRes(List<STOMaterialDetailsResponse> acsenMaterialMasterRes){
		this.acsenMaterialMasterRes = acsenMaterialMasterRes;
	}

	public List<STOMaterialDetailsResponse> getAcsenMaterialMasterRes(){
		return acsenMaterialMasterRes;
	}

	@Override
 	public String toString(){
		return 
			"STOMaterialResponse{" + 
			"acsen_MaterialMaster_Res = '" + acsenMaterialMasterRes + '\'' + 
			"}";
		}
}