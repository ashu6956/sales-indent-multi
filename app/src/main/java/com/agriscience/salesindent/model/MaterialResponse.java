package com.agriscience.salesindent.model;

import com.agriscience.salesindent.model.MaterialMasterDetailResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MaterialResponse {

	@SerializedName("Acsen_MaterialMaster_Res")
	private List<MaterialMasterDetailResponse> acsenMaterialMasterRes;



	public void setAcsenMaterialMasterRes(List<MaterialMasterDetailResponse> acsenMaterialMasterRes){
		this.acsenMaterialMasterRes = acsenMaterialMasterRes;
	}

	public List<MaterialMasterDetailResponse> getAcsenMaterialMasterRes(){
		return acsenMaterialMasterRes;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"acsen_MaterialMaster_Res = '" + acsenMaterialMasterRes + '\'' +
			"}";
		}
}