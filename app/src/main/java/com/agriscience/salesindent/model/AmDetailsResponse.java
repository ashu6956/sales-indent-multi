package com.agriscience.salesindent.model;

import com.google.gson.annotations.SerializedName;

public class AmDetailsResponse {

	@SerializedName("ti_id")
	private String tiId;

	@SerializedName("ti_name")
	private String tiName;

	public void setTiId(String tiId){
		this.tiId = tiId;
	}

	public String getTiId(){
		return tiId;
	}

	public void setTiName(String tiName){
		this.tiName = tiName;
	}

	public String getTiName(){
		return tiName;
	}

	@Override
 	public String toString(){
		return 
			"ResultItem{" + 
			"ti_id = '" + tiId + '\'' + 
			",ti_name = '" + tiName + '\'' + 
			"}";
		}
}