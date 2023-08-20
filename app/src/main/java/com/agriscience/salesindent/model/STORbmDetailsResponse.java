package com.agriscience.salesindent.model;

import com.google.gson.annotations.SerializedName;

public class STORbmDetailsResponse {

	@SerializedName("rbm_name")
	private String rbmName;

	@SerializedName("RBM")
	private String rBM;

	public void setRbmName(String rbmName){
		this.rbmName = rbmName;
	}

	public String getRbmName(){
		return rbmName;
	}

	public void setRBM(String rBM){
		this.rBM = rBM;
	}

	public String getRBM(){
		return rBM;
	}

	@Override
 	public String toString(){
		return 
			"ResultItem{" + 
			"rbm_name = '" + rbmName + '\'' + 
			",rBM = '" + rBM + '\'' + 
			"}";
		}
}