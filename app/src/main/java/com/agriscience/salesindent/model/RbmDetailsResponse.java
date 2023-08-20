package com.agriscience.salesindent.model;

import com.google.gson.annotations.SerializedName;

public class RbmDetailsResponse {

	@SerializedName("rbm_name")
	private String rbmName;

	@SerializedName("rbm_id")
	private String rbmId;

	public void setRbmName(String rbmName){
		this.rbmName = rbmName;
	}

	public String getRbmName(){
		return rbmName;
	}

	public void setRbmId(String rbmId){
		this.rbmId = rbmId;
	}

	public String getRbmId(){
		return rbmId;
	}

	@Override
 	public String toString(){
		return 
			"ResultItem{" + 
			"rbm_name = '" + rbmName + '\'' + 
			",rbm_id = '" + rbmId + '\'' + 
			"}";
		}
}